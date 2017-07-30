package proxy;

public class Host implements Rent{
	
	public Host(){
		System.out.println("房东产生");
	}
	@Override
	public void rent() {
		System.out.println("出租房子");
	}
	public static void main(String[] args){
		Host h=new Host();
	}

}
