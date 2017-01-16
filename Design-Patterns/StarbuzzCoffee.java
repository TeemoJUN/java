package decorate;
/*
 * 装饰者
 * 来自《HeadFirst 设计模式》
 * 
 * CondimentDecorator继承Bverage类是为了获取它的类型而不是它的行为
 * 如果依赖继承，那么类的行为是在编译时就决定了的，组合是在运行时决定的
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
//被装饰的
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
//装饰的东西
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








