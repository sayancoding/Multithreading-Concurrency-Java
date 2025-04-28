package P12_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread is started..");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3,()->{
            System.out.println("All Subsystem is completed..");
        });

        SubSystem s1 = new SubSystem("DB-Server", 2000, barrier);
        SubSystem s2 = new SubSystem("Web-Server", 4000, barrier);
        SubSystem s3 = new SubSystem("All-Services", 2000, barrier);

        executorService.submit(s1);
        executorService.submit(s2);
        executorService.submit(s3);
        
        System.out.println("Main thread is finished..");
        executorService.shutdownNow();
    }
}
