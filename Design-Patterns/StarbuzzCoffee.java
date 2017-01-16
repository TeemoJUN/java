package decorate;
/*
 * װ����
 * ���ԡ�HeadFirst ���ģʽ��
 * 
 * CondimentDecorator�̳�Bverage����Ϊ�˻�ȡ�������Ͷ�����������Ϊ
 * ��������̳У���ô�����Ϊ���ڱ���ʱ�;����˵ģ������������ʱ������
 * 
 * */
abstract class  Beverage{
	String description="Unkonw Beverage";
	
	public String getDescription(){
		return this.description;
	}
	public abstract double cost();
}

abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}
//��װ�ε�
class Espresso extends Beverage{
	public Espresso(){
		description=" Espresso ";
	}
	@Override
	public double cost(){
		return 0.22;
	}
}
class HouseBlend extends Beverage{
	public HouseBlend(){
		description=" HouseBlend coffee ";
	}
	@Override
	public double cost(){
		return 0.11;
	}
}
//װ�εĶ���
class Mocha extends CondimentDecorator{
	Beverage beverage;
	public Mocha(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription(){
		return beverage.getDescription()+" Mocha ";
	}
	@Override
	public double cost() {
		return 0.33+beverage.cost();
	}
}
class Soy extends  CondimentDecorator{
	Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription(){
		return beverage.getDescription()+" Soy ";
	}
	@Override
	public double cost(){
		return 0.44+beverage.cost();
	}
}

public class StarbuzzCoffee {
	public static void main(String[] args){
		Beverage beverage=new Espresso();
		System.out.println(beverage.getDescription()+" $ "+beverage.cost());
		
		Beverage beverage1=new HouseBlend();
		beverage1=new Mocha(beverage1);
		beverage1=new Mocha(beverage1);
		beverage1=new Soy(beverage1);
		System.out.println(beverage1.getDescription()+" $ "+beverage1.cost());
		
		
	}
}








