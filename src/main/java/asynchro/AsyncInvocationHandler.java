package asynchro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Future;

import org.aopalliance.intercept.MethodInvocation;

public class AsyncInvocationHandler implements InvocationHandler {

    private MethodInvocation invocation;

    public AsyncInvocationHandler(MethodInvocation invocation) {
        this.invocation = invocation;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object object = invocation.proceed();

        if (object == null) {
            return null;
        } else if (object instanceof Future<?>) {
            Future<?> future = (Future<?>) object;
            return future.get();
        } else {
            throw new RuntimeException();
        }

    }
}
