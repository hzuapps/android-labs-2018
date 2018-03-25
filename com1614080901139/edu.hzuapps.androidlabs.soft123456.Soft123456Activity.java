public class demo1 {
	//1.变量隐式转换
	private static void test1(){
		int score1 = 90;
		double score2 = score1;
		System.out.println(score2);
		//int(4字节)会被转化为double(8字节) 92 => 92.0
		//规则
		//1.同源数据的转换
		//int可以转化为float,double,不可以转换为char
		//2.数据类型大小限制
		//double(8字节)不会自动转化为int(4字节)
	}
	//2.变量显示转换
	private static void test2(){
		double score1 = 92.123;
		int score2 = (int)score1;
		System.out.println(score2);
	}
	public static void main(String args[]){
		//test1();
		test2();
	}
}
