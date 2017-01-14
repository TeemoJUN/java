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
	}
}
