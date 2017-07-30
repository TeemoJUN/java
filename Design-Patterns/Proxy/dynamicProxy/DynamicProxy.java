package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	private Object relObj;
	
	
	
	public Object createProxy(Object obj){
		this.relObj=obj;
		System.out.println("代理对象创建");
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), relObj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用代理对象方法定位到真实对象方法上");
		return method.invoke(relObj, args);
	}
}
