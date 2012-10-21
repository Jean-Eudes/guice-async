package test;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import asynchro.TraitementImpl;

import com.google.inject.internal.cglib.proxy.Enhancer;
import com.google.inject.internal.cglib.proxy.InvocationHandler;

public class TestCGLibProxy {

	public static void main(String[] args) throws Exception {
		Callable traitement = (Callable) createProxy();
		System.out.println(traitement.call());
	}
    public static Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{Callable.class});
        //enhancer.
        enhancer.setCallback(new InvocationHandler(){

			public Object invoke(Object arg0, Method arg1, Object[] arg2)
					throws Throwable {
				return new TraitementImpl().sayHello();
			}});
        return enhancer.create();
   }
}
