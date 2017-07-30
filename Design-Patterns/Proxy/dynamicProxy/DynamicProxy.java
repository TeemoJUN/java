package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	private Object relObj;
	
	
	
	public Object createProxy(Object obj){
		this.relObj=obj;
		System.out.println("������󴴽�");
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), relObj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("���ô�����󷽷���λ����ʵ���󷽷���");
		return method.invoke(relObj, args);
	}
}
