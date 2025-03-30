package P4_Lock_Faireness;

import static U1_Utils.Utils.getCurrentThreadName;
import static U1_Utils.Utils.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    
    Lock lock;

    Resource(boolean loackFaireness){
        lock = new ReentrantLock(loackFaireness);
    }

    public void accessResource(){
        lock.lock();
        print("{} : Accessing resource..", getCurrentThreadName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally{
            print("{} : Releasing resource..", getCurrentThreadName());
            lock.unlock();
        }
    }
}
