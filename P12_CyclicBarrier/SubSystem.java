package P12_CyclicBarrier;

import static U1_Utils.Utils.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SubSystem implements Runnable {

    private String name;
    private int timeDuration;
    private CyclicBarrier barrier;

    public SubSystem(String name, int timeDuration, CyclicBarrier barrier){
        this.name = name;
        this.timeDuration = timeDuration;
        this.barrier = barrier;
    }

    @Override
    public void run(){
        print("{} :: {} is starting..", getCurrentThreadName(),name);
        try {
            Thread.sleep(timeDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally{
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
        }
        print("{} :: {} is finished !!", getCurrentThreadName(),name);
    }
    
}
