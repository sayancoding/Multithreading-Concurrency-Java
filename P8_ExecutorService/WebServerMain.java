package P8_ExecutorService;

import static U1_Utils.Utils.getCurrentThreadName;
import static U1_Utils.Utils.print;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebServerMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        long startTime = System.currentTimeMillis();

        for(int i = 0; i<10; i++){
            executor.execute(new RequestHandler("REQ_"+i));
        }

        executor.shutdown(); // Stop accepting new request to executor-service

        try {
            // check if any remaining task within time or not
            if(executor.awaitTermination(5, TimeUnit.SECONDS) == false){ 
                List<Runnable> notProcessList = executor.shutdownNow();
                print("{} : Not Processed items : {}", getCurrentThreadName(),notProcessList.size());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();

        print("Time Consumed {} ms", (endTime-startTime));
    }
}
