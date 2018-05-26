#include <sys/socket.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <errno.h>
#include <netinet/in.h>
#include <pthread.h>
#include <arpa/inet.h>
#include <string.h>
#include <signal.h>
#include <sys/epoll.h>
#include <fcntl.h>
#include <pthread.h>
#include <sys/time.h>
#include "ps.h"
#include <iostream>
using namespace std;	
MYSQL mysql,*con;
#define serveaddr "120.79.37.250"
#define debug "192.168.0.160"

#define ERR_EXIT(m) do \
{ \
 perror(m); \
 exit(EXIT_FAILURE); \
} while(0)
/*epoll模型*/
/*noblock socket*/
//void sig_hand(int signo);
int j=0;
void setNOBLOCKING(int sockfd)
{
	int opts=0;
	opts=fcntl(sockfd,F_GETFL);
	if(opts<0)
		ERR_EXIT("fct get");
	opts=(opts | O_NONBLOCK);
	if(fcntl(sockfd,F_SETFL,opts)<0)
		ERR_EXIT("fct set");
	return;
}
struct sock_port
{
	int confd;
	struct sockaddr_in peeraddr;
	sock_port *next;
};
class sock
{
private:
	static int i;
	static sock_port *cfd,*first;
	static epoll_event *events;
public:
	static int epfd;
	int listenfd;
	int std_in;
	sock(int listen)
	{
		listenfd=listen;
		setNOBLOCKING(listenfd);
		//i=0;
		epfd=epoll_create(1);
		if(epfd==-1)
		ERR_EXIT("epfd");
		struct epoll_event ev,es;
		ev.data.fd=listenfd;
		ev.events=EPOLLIN|EPOLLET;
		if(epoll_ctl(epfd,EPOLL_CTL_ADD,listenfd,&ev)==-1)
		{
			close(listenfd);
			printf("ctl error\n");		
		}
		cfd=new sock_port();
		first=cfd;
		mysql_star();
	}
	~sock(){
		sock_port *p;
		while(first->next!=NULL)
		{
			p=first;
			first=first->next;
			delete p;
		}
		mysql_close(con);
	}
	
	static void *link(void *stat)		//业务逻辑处理线程
	{

		int *connect;
		events=(struct epoll_event *)stat;
		connect=&events->data.fd;

		char a[J_MAX];
		bzero(a,sizeof(a));
		int n;
		read(*connect,a,sizeof(a));	//业务句柄
		printf("%s\n",a);
		a[strlen(a)-1]=0;
		//printf("%s\n",a);
		if(strcmp(a,"create")==0)
		{
				id(*connect,con,mysql);
				printf("hava one create\n");
		}
		else if(strcmp(a,"signin")==0)
			{
				printf("enter\n");
				submit(*connect,con,mysql);
			}
		else if(strcmp(a,"find")==0)
			found(*connect,con,mysql);
		else if(strcmp(a,"getmenu")==0)
			getmenu(*connect,con,mysql);
		else if(strcmp(a,"createsid")==0)
			createsid(*connect,con,mysql);
		close(*connect);
		sock_port *p,*q;
		p=first;
		if(first->confd==*connect)
		{
			p=p->next;
			delete first;
			first=p;
		}
		else
		while(p->next!=NULL)
		{

			q=p;
			p=p->next;
			if(p->confd==*connect)
			{
				q->next=p->next;
				delete p;
			}
		}
		i--;

	}
	void mysql_star()		//数据库初始化
	{
		mysql_init(&mysql);
    	con=mysql_real_connect(&mysql,"localhost","dbuser1","123456","db1",0,0,0);
   		if(con==NULL)
        	ERR_EXIT(mysql_error(&mysql));
    	int ret=mysql_query(con, "set names utf8");
    	MYERR(ret,mysql);
    	printf("link success\n");
	}
	int Accept(void)		//连接创建套接字
	{
		struct sockaddr_in peeraddr;
		socklen_t peerlen=sizeof(peeraddr);
		cfd->confd=accept(listenfd,(struct sockaddr*)&peeraddr,&peerlen);
		if(cfd->confd<0)
		{
			printf("error\n");
			return -1;
		}
		printf("Ip=%s \nhtons=%d \n%d\n",inet_ntoa(peeraddr.sin_addr),htons(peeraddr.sin_port),i);
		setNOBLOCKING(cfd->confd);
		struct epoll_event ev;
		ev.data.fd=cfd->confd;
		ev.events=EPOLLIN|EPOLLET;
		if(epoll_ctl(epfd,EPOLL_CTL_ADD,cfd->confd,&ev)==-1)
		{
			close(cfd->confd);
			printf("ctl error\n");
			return -1;	
		}
		sock_port *p;
		p=new sock_port;
		p->next=NULL;
		cfd->next=p;
		cfd=p;
		i++;
		return 1;
	}
	
};

int sock::i=0;
sock_port *sock::cfd=NULL,*sock::first=NULL;
int sock::epfd=0;
epoll_event *sock::events=NULL;
pthread_t idt[100];

struct timeval idt_time[100];
int socketfd[100];

void sig_hand(int signo)		//线程退出
{
	printf("exit\n");	
	//j--;
	pthread_exit(0);
}
static void* sig(void *n)		
{
	struct sigaction	actions;
	actions.sa_flags = 0;  
    actions.sa_handler = sig_hand;
    sigaction(SIGALRM,&actions,NULL);
    struct timeval nowtime;
	while(1)
	{
		//sleep(5);
		gettimeofday(&nowtime,NULL);
		//printf("%d\n",j);
		for(int t=0;t<100;t++)
        {
        	if(idt[t]==0)
        		continue;
        		int kill_ret=pthread_kill(idt[t],0);
                if(kill_ret!=ESRCH)
                {
                	if(nowtime.tv_sec-idt_time[t].tv_sec>=5)
                    	{
                    		pthread_kill(idt[t],SIGALRM);
                			close(socketfd[t]);
                		}
                }
        } 
        sleep(1);     
    }
}

int main(void)
{
	int set;
	struct sockaddr_in servaddr;
	int opt = 1; 
	int listenfd;
		
	if((listenfd=socket(AF_INET,SOCK_STREAM,0))<0)
		ERR_EXIT("socket");
	
	bzero(&servaddr,sizeof(servaddr));
	servaddr.sin_family = AF_INET;

	inet_pton(AF_INET,serveaddr,&servaddr.sin_addr);

	servaddr.sin_port   = htons(43491);

	if(setsockopt(listenfd,SOL_SOCKET,SO_REUSEADDR,(char*)&opt,sizeof(opt))<0)
	ERR_EXIT("setsockopt");
	
	if(bind(listenfd,(struct sockaddr*)&servaddr,sizeof(struct sockaddr_in))<0)
		ERR_EXIT("bind");
		

	if(listen(listenfd,SOMAXCONN)<0)
		ERR_EXIT("listen");
	int connect;
	struct epoll_event events[20];
	int nfds;
	sock client(listenfd);
	pthread_t contrl;
	pthread_create(&contrl,NULL,sig,NULL);
	while(1)
	{
		nfds=epoll_wait(client.epfd,events,20,5000);
		if(nfds==0)
		{
			//printf("all client exit");
			//break;
		}
		else
		{
			for(int i=0;i<nfds;i++)
			{
				if(events[i].data.fd==listenfd)
					client.Accept();
				else if(events[i].events&EPOLLIN)
				{	

					pthread_create(idt+j,NULL,client.link,(void *)&events[i]);
					gettimeofday(&idt_time[j],NULL);
					socketfd[j]=events[i].data.fd;
					//mysql_star(events[i].data.fd,(struct sockaddr_in *)(&events[i].data.fd+sizeof(int)));
					if(epoll_ctl(client.epfd,EPOLL_CTL_DEL,events[i].data.fd,events)==-1)
					{
						printf("DEL error\n");
					}
					j=++j%100;
				}
			}
		}

	}
	return 0;
}
