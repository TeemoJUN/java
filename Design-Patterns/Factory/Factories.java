package Test_9;
/*
* java编程思想P186
*/
interface Service{
	void method1();
	void method2();
}

interface ServiceFactory{
	Service getService();
}

class Implementation1 implements Service{
	
	Implementation1(){}
	@Override
	public void method1() {
		System.out.println("Implementation1 method1");
		
	}

	@Override
	public void method2() {
		System.out.println("Implementation2 method2");
	}
}

class Implementation1Factory implements ServiceFactory{

	@Override
	public Service getService() {
		return new Implementation1();
	}
}

public class Factories {
	public static void serviceConsumer(ServiceFactory fact){
		Service s=fact.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args){
		serviceConsumer(new Implementation1Factory());
	}
}
