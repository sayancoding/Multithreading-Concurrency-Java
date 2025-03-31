package P11_CountDownLatch;

import static U1_Utils.Utils.print;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Worker dependency_1 = new Worker(1, latch); 
        Worker dependency_2 = new Worker(2, latch); 
        Worker dependency_3 = new Worker(3, latch); 

        executorService.submit(dependency_1);
        executorService.submit(dependency_2);
        executorService.submit(dependency_3);

        latch.await(); //block current thread (main) until all above complete

        print("All Dependency threads are completed..");
        executorService.shutdownNow();

    }
    
}
