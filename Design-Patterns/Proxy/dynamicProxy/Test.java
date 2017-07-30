package proxy;

public class Test {
	public static void main(String[] args){
		Host h=new Host();
		DynamicProxy dp=new DynamicProxy();
		Rent rent=(Rent)dp.createProxy(h);
		rent.rent();
	}
}
