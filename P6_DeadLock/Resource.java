package P6_DeadLock;

import static U1_Utils.Utils.getCurrentThreadName;
import static U1_Utils.Utils.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    
    public void access1() throws InterruptedException{
        lock1.lock();
        print("{} : Accessing resource 1...", getCurrentThreadName());
        Thread.sleep(5000);
        access2();
        lock1.unlock();
    }
    public void access2() throws InterruptedException{
        lock2.lock();
        print("{} : Accessing resource 2...", getCurrentThreadName());
        Thread.sleep(5000);
        print("{} : waiting trying to access resource 1",getCurrentThreadName());
        access1();
        lock2.unlock();
    }
}
