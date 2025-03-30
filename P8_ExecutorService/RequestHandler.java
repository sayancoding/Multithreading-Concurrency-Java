package P8_ExecutorService;

import static U1_Utils.Utils.*;

import java.util.Random;

public class RequestHandler implements Runnable {

    private String requestId;

    public RequestHandler(String id){
        requestId = id;
    }

    @Override
    public void run() {
         print("{} : Processing request - {}", getCurrentThreadName(),requestId);
         try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        print("{} : Processed request - {}",getCurrentThreadName(),requestId);
    }
    
}
