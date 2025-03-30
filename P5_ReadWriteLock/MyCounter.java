package P5_ReadWriteLock;

import static U1_Utils.Utils.getCurrentThreadName;
import static U1_Utils.Utils.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCounter {
    private int counter = 0;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock wriLock = readWriteLock.writeLock();
    

    public void increase() throws InterruptedException{
        wriLock.lock();
        print("{} : Increasing..", getCurrentThreadName());
        counter ++;
        Thread.sleep(1000);
        wriLock.unlock();
    }

    public void viewCounterValue() throws InterruptedException{
        readLock.lock();
        print("{} : Counter value : {} ", getCurrentThreadName(),counter);
        Thread.sleep(500);
        readLock.unlock();
    }
}
