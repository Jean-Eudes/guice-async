package asynchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aopalliance.intercept.MethodInterceptor;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class MyModule extends AbstractModule {

    protected void configure() {
        bind(Traitement.class).to(TraitementImpl.class);
        ExecutorService pool = Executors.newFixedThreadPool(2);


        MethodInterceptor interceptor = new AsynchronousInterceptor(pool);
        bindInterceptor(Matchers.any(), Matchers
                .annotatedWith(Asynchronous.class), interceptor);

    }
}
