package test;
/*
 * 来自于《headFirst 设计模式》
 *
 * */
import java.util.ArrayList;

interface Subject{
	void registerObserver(Observer ob);
	void removeObserver(Observer ob);
	void notifyObservers();
}
interface Observer{
	void update(float temp,float humitidy,float pressure);
}

interface DisplayElement{
	void display();
}


class WeatherDate implements Subject{
	private ArrayList<Observer> observers;
	
	private float temp;
	private float humitidy;
	private float pressure;
	
	public WeatherDate(){
		this.observers=new ArrayList<Observer>();
	}
	@Override
	public void registerObserver(Observer ob) {
		observers.add(ob);
		
	}
	@Override
	public void removeObserver(Observer ob) {
		int i=observers.indexOf(ob);
		if(i>0){
			observers.remove(i);
		}
		
	}
	@Override
	public void notifyObservers() {
		for(Observer ob:observers){
			ob.update(temp, humitidy, pressure);
		}
		
	}
	public void measureChange(){
		notifyObservers();
	}
	
	public void serMeasureDate(float temp,float humitidy,float pressure){
		this.temp=temp;
		this.humitidy=humitidy;
		this.pressure=pressure;
		notifyObservers();
	}
}

class CurrentConditionDisplay implements Observer,DisplayElement{

	private float temperature;
	private float humitidy;
	
	private Subject weatherDate;
	
	public CurrentConditionDisplay(Subject a){
		this.weatherDate=a;
		a.registerObserver(this);
	}
	
	
	@Override
	public void display() {
		System.out.println("CurrentCondition: "+temperature+"   "+humitidy);
	}

	@Override
	public void update(float temp, float humitidy, float pressure) {
		this.temperature=temp;
		this.humitidy=humitidy;

		display();		
	}
	
}


public class WeatherStation {
	public static void main(String[] args){
		WeatherDate weatherDate=new WeatherDate();
		//注册		
		CurrentConditionDisplay currentDisplay=new CurrentConditionDisplay(weatherDate);
		
		weatherDate.serMeasureDate(1.1f, 12.3f, 1.4f);
	}
}






