#ifndef _PS_H_
#define _PS_H_
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <mysql/mysql.h>
#include <stdlib.h>
#define ERR_EXIT(m) do \
{ \
 perror(m); \
 exit(EXIT_FAILURE); \
} while(0)

#define SQLERR(m) do \
{ \
 mysql_error(m); \
 return 0; \
} while(0);
#define SUCCESS 1
#define SU "1\n"
#define ER "0\n"
#define J_MAX 1024
#define Pthread_mutex_lock pthread_mutex_lock
#define Pthread_mutex_unlock pthread_mutex_unlock
//#define True(m) \
 if(m==0) \
  return 0;
#define True(m) \
while(1) \
	{ \
		int size;	\
		if((size=m)==0) \
			{ \
				ERR_EXIT("client exit"); \
			}	\
		else if(size<0&&errno == EAGAIN)	\
			continue;	\
		else 	\
			{	\
				break;		\
			}\
	}
pthread_mutex_t LOCK=PTHREAD_MUTEX_INITIALIZER;
int randomnumber(int a,int b)
{
    return rand()%(b-a+1)+a;
}
int MYERR(int ret,MYSQL mysql)
{
	if(ret!=0)
	{
		SQLERR(&mysql);
	}
	else return 1;
}

void getmysql_row(MYSQL *con,char (*mes)[20],int n,int colume)
{
	MYSQL_RES *res;
	MYSQL_ROW row;
	res=mysql_store_result(con);
	MYSQL_FIELD *field;
	int count=0;
	int i=0;
	while(1)
	{
		row=mysql_fetch_row(res);
		if(row==NULL)		
			break;
		for(int j=0;j<colume;j++)
		strcat(*mes+sizeof(char)*n*i,row[j]);
		//printf("%s\n",*mes);
		i++;
	}

	mysql_free_result(res);
}
int submit(int connect,MYSQL *con,MYSQL mysql)
{
	int flag=0;
	char id[J_MAX];
	char key[J_MAX];
	bzero(id,sizeof(id));
	bzero(key,sizeof(key));
	True(read(connect,id,sizeof(id)));
	True(read(connect,key,sizeof(key)));

	id[strlen(id)-1]=0;
	key[strlen(key)-1]=0;
	printf("%s\n%s\n",id,key);	
	char insert[J_MAX];
	bzero(insert,sizeof(insert));
	sprintf(insert,"select userkey from apassword WHERE username='%s'",id);
	Pthread_mutex_lock(&LOCK);
	int ret=mysql_query(con,insert);
	True(MYERR(ret,mysql));	
	char msg[1][20];
	bzero(msg,sizeof(msg));
	getmysql_row(con,msg,20,1);
	Pthread_mutex_unlock(&LOCK);
	int i;
	if(id[0]!=0&&strcmp(msg[0],key)==0)
	{
		//printf("error\n");
		write(connect,SU,strlen(SU));
		bzero(insert,sizeof(insert));
		sprintf(insert,"select pidname from apasslink where pid in(select pid from apassword where username='%s')",id);
		char msg2[10][20];
		bzero(msg2,sizeof(msg2));
		Pthread_mutex_lock(&LOCK);
		mysql_query(con,insert);
		getmysql_row(con,msg2,20,1);
		Pthread_mutex_unlock(&LOCK);
		char sendmsg[200];
		bzero(sendmsg,sizeof(sendmsg));
		int i=0;
		while(msg2[i][0]!='\0')
		{
			//printf("%s\n",msg2[i]);	
			strcat(sendmsg,msg2[i]);	
			strcat(sendmsg,"$");
			i++;
		}
		strcat(sendmsg,"|");
		printf("%s\n",sendmsg);
		write(connect,sendmsg,strlen(sendmsg));
	}
	else
	{
		write(connect,ER,strlen(ER));
		write(connect,ER,strlen(ER));
	}

	return SUCCESS;
}

int id(int connect,MYSQL *con,MYSQL mysql)
{
	int flag=0;

	printf("insert\n");
	char id[J_MAX];
	char key[J_MAX];	
	char question[J_MAX];
	char answer[J_MAX];
	char message[J_MAX];
	char clas[J_MAX];

	bzero(id,sizeof(id));
	bzero(key,sizeof(key));
	bzero(question,sizeof(question));
	bzero(answer,sizeof(answer));
	bzero(message,sizeof(message));
	bzero(clas,sizeof(clas));

	True(read(connect,id,sizeof(id)));
	printf("%s\n",id);

	True(read(connect,key,sizeof(key)));
	printf("%s\n",key);

	True(read(connect,question,sizeof(question)));
	printf("%s\n",question);

	True(read(connect,answer,sizeof(answer)));
	printf("%s\n",answer);

	True(read(connect,clas,sizeof(clas)));
	printf("%s\n",clas);

	id[strlen(id)-1]=0;
	key[strlen(key)-1]=0;
	question[strlen(question)-1]=0;
	answer[strlen(answer)-1]=0;
	clas[strlen(clas)-1]=0;
	char insert[200];

	bzero(insert,sizeof(insert));
	sprintf(insert,"INSERT INTO apassword (username,userkey,question,answer,class) VALUES ('%s','%s','%s','%s',%s) ",id,key,question,answer,clas);
	//printf("%s\n",insert);
	Pthread_mutex_lock(&LOCK);
	int ret=mysql_query(con,insert);
	Pthread_mutex_unlock(&LOCK);
	if(ret!=0)
	{
		char cf[]="0\n";
		printf("%s",cf);
		write(connect,cf,strlen(cf));
		
	}
	else
    {
		//printf("have one create ip:%s\n",inet_ntoa(peeraddr.sin_addr));
        char succ[]="1\n";
        write(connect,succ,strlen(succ)); 
	}
	return SUCCESS;
	//mysql_close(con);
}
int createsid(int connect,MYSQL *con,MYSQL mysql)
{
	char username[J_MAX];
	char pidname[J_MAX];
	bzero(pidname,sizeof(pidname));
	bzero(username,sizeof(username));
	True(read(connect,username,sizeof(username)));
	True(read(connect,pidname,sizeof(pidname)));
	username[strlen(username)-1]='\0';
	pidname[strlen(pidname)-1]='\0';
	char sqlcom[200];
	bzero(sqlcom,sizeof(sqlcom));
	sprintf(sqlcom,"insert into apasslink (pid,pidname,x,y) values ((select pid from apassword where username='%s'),'%s',0,0)",username,pidname);
	printf("%s\n",sqlcom);
	int ret=mysql_query(con,sqlcom);
	//MYERR(ret,mysql);
	if(ret!=0)
		write(connect,ER,strlen(ER));
	else
		write(connect,SU,strlen(SU));
}

int found(int connect,MYSQL *con,MYSQL mysql)
{
	MYSQL_ROW row;	
	MYSQL_RES *res;
	char id[J_MAX];
	bzero(id,sizeof(id));
	True(read(connect,id,sizeof(id)));	//user name	
	char found[100];
	id[strlen(id)-1]='\0';
	sprintf(found,"select question from apasslink WHERE username='%s'",id);
	Pthread_mutex_lock(&LOCK);
	int ret=mysql_query(con,found);
	MYERR(ret,mysql);

	res=mysql_store_result(con);
	int count=0;
	row=mysql_fetch_row(res);
	Pthread_mutex_unlock(&LOCK);
	if(row==0)
	{
		True(write(connect,ER,strlen(ER)));	//without this user
		return 0;
	}

	int i;
	char sendto[J_MAX];
	bzero(sendto,sizeof(sendto));
	strcpy(sendto,row[0]);
	//sendto[strlen(sendto)]='\0';
	//printf("%d\n",strlen(sendto));
	char a[]="\n";
	strcat(sendto,a);
	//printf("%s",sendto);
	True(write(connect,sendto,strlen(sendto)));	//return qustion
	sendto[strlen(sendto)-1]='\0';
	char readfrom[J_MAX];
	bzero(readfrom,sizeof(readfrom));
	True(read(connect,readfrom,sizeof(readfrom)));
	readfrom[strlen(readfrom)-1]='\0';
	sprintf(found,"select answer from apassword WHERE(question ='%s')",sendto);		
	//printf("%s\n",found);
	Pthread_mutex_lock(&LOCK);
	ret=mysql_query(con,found);
	res=mysql_store_result(con);

	char key[J_MAX];
	bzero(key,sizeof(key));
	row=mysql_fetch_row(res);
	Pthread_mutex_unlock(&LOCK);
	if(strcmp(row[0],readfrom)==0)
	{
		write(connect,SU,strlen(SU));	//accept answer,tell the android;
		read(connect,key,sizeof(key));	//read new key;
	}
	else
	{
		write(connect,ER,sizeof(ER));
		return 0;	//the question error
	}
	//printf("%s",key);
	key[strlen(key)-1]='\0';
	bzero(found,sizeof(found));
	sprintf(found,"update apassword set username='%s' WHERE userkey='%s';",key,id);
	Pthread_mutex_lock(&LOCK);
	ret=mysql_query(con,found);
	Pthread_mutex_lock(&LOCK);
	mysql_free_result(res);
	return SUCCESS;
	//printf("ss\n");
	//mysql_close(con);*/
}

int getmenu(int connect,MYSQL *con,MYSQL mysql)
{
	char menumes[100];
	bzero(menumes,sizeof(menumes));
	True(read(connect,menumes,sizeof(menumes)));
	printf("%s",menumes);
	//menumes[strlen(menumes)-1]='\0';
	char sqlcom[200];
	bzero(sqlcom,sizeof(sqlcom));
	sprintf(sqlcom,"select distinct x,y from classtable where class in (select class from apassword where pid in (select pid from apasslink where pidname='%s'))",menumes);
	printf("%s\n",sqlcom);
	int ret=mysql_query(con,sqlcom);
	MYERR(ret,mysql);
	char row[77][20];
	bzero(row,sizeof(row));
	getmysql_row(con,row,20,2);
	char sendmes[100];
	bzero(sendmes,sizeof(sendmes));
	for(int i=0;i<70;i++)
	{
		if(row[i][0]=='\0')
			break;
		strcat(sendmes,row[i]);
	}
	strcat(sendmes,"|\n");
	printf("%s",sendmes);
	write(connect,sendmes,strlen(sendmes));
}
#endif
