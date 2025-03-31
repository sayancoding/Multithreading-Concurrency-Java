package P10_CallableRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ApiTask t1 = new ApiTask("product-api");
        ApiTask t2 = new ApiTask("inventory-api");
        ApiTask t3 = new ApiTask("order-api");

        EmailTask e1 = new EmailTask();
        

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<String> res1 = executorService.submit(t1);
        Future<String> res2 = executorService.submit(t2);
        Future<String> res3 = executorService.submit(t3);
        executorService.execute(e1);
        

        executorService.shutdown();

        System.out.println(res1.get(5, TimeUnit.SECONDS));
        System.out.println(res2.get(5, TimeUnit.SECONDS));
        System.out.println(res3.get(5, TimeUnit.SECONDS));
    }
}
