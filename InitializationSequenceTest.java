package test;
class Father{
	static{
		System.out.println("Father Static");
	}
	{
		System.out.println("........Father........");
	}
	public Father(){
		System.out.println("I am Father");
	}
}
class Son extends Father{
	public Son(){
		super();
		System.out.println("I am Son");
	}
	static {
		System.out.println("Son Static");
	}
	{
		System.out.println(".............Son...........");
	}
}
public class InitializationSequenceTest {
	public static void main(String[] args){
		Son a=new Son();
		/*
		 * 	Father Static
		 *	Son Static
		 *	........Father........
		 *	I am Father
		 *	.............Son...........
		 *	I am Son
		 * */
		/*
		 * 先父类后子类；先静态后实例；最后构造器。
		 
		 
		 * 先将执行父类的静态块后子类静态块；
		 * 然后再进行父类的实例区进行初始化，再父类构造器
		 * 最后子类实例区，子类构造器
		 *
		 * */
			
	}
}
