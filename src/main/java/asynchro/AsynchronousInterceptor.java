package asynchro;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AsynchronousInterceptor implements MethodInterceptor {

    private ExecutorService pool;

    public AsynchronousInterceptor(ExecutorService pool) {
        this.pool = pool;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {

        InvocationHandler handler = new AsyncInvocationHandler(invocation);

        Callable<Future<?>> callable = (Callable) Proxy.newProxyInstance(Thread
                .currentThread().getContextClassLoader(),
                new Class[]{Callable.class}, handler);

        Field field = invocation.getClass().getDeclaredField("index");
        field.setAccessible(true);
        field.setInt(invocation, field.getInt(invocation) + 1);

        Future<?> future = pool.submit(callable);

        return future;
    }
}
