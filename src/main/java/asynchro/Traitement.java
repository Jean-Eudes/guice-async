package asynchro;

import java.util.concurrent.Future;


public interface Traitement {

    Future<Integer> traitement();

    String sayHello();

    void test();
}
