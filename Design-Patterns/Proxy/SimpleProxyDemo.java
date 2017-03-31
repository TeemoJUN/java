package test_14;


class RealObject implements Interface{
	
	@Override
	public void somethingElse(String arg) {
			System.out.println("somethingElse "+arg);
	}

	@Override
	public void doSomething() {
		System.out.println("something");
	}
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied=proxied;
	}
	@Override 
	public void doSomething(){
		System.out.println("SimpleProxy dosomething");
		proxied.doSomething();
	}
	@Override
	public void somethingElse(String arg){
		System.out.println("SimpleProxyElse "+arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("AAAA");
	}
	public static void main(String[] args){
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
















