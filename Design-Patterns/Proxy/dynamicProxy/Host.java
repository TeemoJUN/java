package proxy;

public class Host implements Rent{
	
	public Host(){
		System.out.println("��������");
	}
	@Override
	public void rent() {
		System.out.println("���ⷿ��");
	}
	public static void main(String[] args){
		Host h=new Host();
	}

}
