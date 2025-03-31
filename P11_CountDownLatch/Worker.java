package P11_CountDownLatch;

import java.util.concurrent.CountDownLatch;
import static U1_Utils.Utils.*;


class Worker implements Runnable{

    private int id;
    private CountDownLatch latch;

    public Worker(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        print("{} :: Worker-{} is starting..", getCurrentThreadName(),id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            print("{} :: interrupted..", getCurrentThreadName());
        }
        finally{
            print("{} :: Worker-{} is finished", getCurrentThreadName(),id);
            latch.countDown();
        }
    }

}