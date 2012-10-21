package asynchro;

import java.util.Random;
import java.util.concurrent.Future;


public class TraitementImpl implements Traitement {

    @Asynchronous
    public Future<Integer> traitement() {
        try {
            System.out.println("ca marche");
            Thread.sleep(5000);
            System.out.println("cestbon");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new AsyncResult<>(new Random().nextInt());
    }

    @Asynchronous
    public String sayHello() {
        return "hello";
    }

    @Asynchronous
    public void test() {
        System.out.println("test");

    }

}
