package asynchro;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;

public class Main {
    public static void main(String[] args) throws Exception {
        Module m = new MyModule();
        Injector injector = Guice.createInjector(Stage.PRODUCTION, m
        );
        Traitement traitement = (Traitement) injector
                .getInstance(Traitement.class);

        System.out.println("OK");
        // Future<Integer> future = traitement.traitement();
        // System.out.println(future.isDone());

        System.out.println("OK");
        // System.out.println("value : " + future);
        // System.out.println("value2 : " + future.get());
        System.out.println(traitement.sayHello());
        traitement.test();
        // System.out.println(future.isDone());

    }

}
