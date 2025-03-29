package P3_ReentrantLock_2;

import static U1_Utils.Utils.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private long totalBalance = 0;
    Lock lock = new ReentrantLock();

    public void deposit(long amount) throws InterruptedException{
        lock.lock();
        print("{} : Depositing amount Rs {} ...",getCurrentThreadName(),amount);
        totalBalance += amount;
        Thread.sleep(3000);
        print("{} : After deposit Current balance Rs {} ",getCurrentThreadName(),totalBalance);
        lock.unlock();
    }

    public void withdraw(long amount) throws InterruptedException{
        lock.lock();
        print("{} : Withdrawing amount Rs {} ...",getCurrentThreadName(),amount);
        Thread.sleep(3000);

        if(totalBalance >= amount){
            totalBalance -= amount;
            print("{} : After withdraw Current balance Rs {} ",getCurrentThreadName(),totalBalance);
        }else{
            print("{} : Insufficient balance to withdraw !!",getCurrentThreadName());
        }
        lock.unlock();
    }
    private void getTotalBalance(){
        lock.lock();
        print("{} : Total Balance Rs {}",getCurrentThreadName(),totalBalance);
        lock.unlock();
    }

    public void performTransaction(int depositAmount, int withdrawAmount) throws InterruptedException{
        deposit(depositAmount);
        withdraw(withdrawAmount);
    }
}
