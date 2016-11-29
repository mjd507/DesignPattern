package JavaSE_Senior.DesignPattern.JavaCodes.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynamic {
	public static void main(String[] args) {
		ZhangSan zs = new ZhangSan();
		InvocationHandler handler = new Proxyer(zs);
		Person proxyObj = (Person) Proxy.newProxyInstance(zs.getClass().getClassLoader(), zs.getClass().getInterfaces(), handler);
		proxyObj.doSomething();
		
		//second way to use dynamic proxy
		Person newProxyInstance = (Person) Proxy.newProxyInstance(zs.getClass().getClassLoader(), zs.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(zs, args);
				return null;
			}
		});
		newProxyInstance.doSomething();
	}
}

interface Person{
	void doSomething();
}

class ZhangSan implements Person{

	@Override
	public void doSomething() {
		System.out.println("coding...");
	}
	
}

class Proxyer implements InvocationHandler{
	private Object obj;//动态代理的真实对象
	
	public Proxyer(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before proxy");
		method.invoke(obj, args);
		System.out.println("after proxy");
		return null;
	}

	
	
}

