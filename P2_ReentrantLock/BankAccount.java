package P2_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    
    Lock lock = new ReentrantLock();

    private int balance = 100;
    
    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(getCurrentThreadName() + " : Attempting to withdraw amount Rs: "+amount);
        
        
        if(lock.tryLock(10, TimeUnit.SECONDS))
        {
            if(balance >= amount){
                System.out.println(getCurrentThreadName() + " : Processing withdraw amount Rs: "+amount);
                balance = balance - amount;
                Thread.sleep(5000); 
                System.out.println(getCurrentThreadName() + " : Withdraw has been successful :)");
                System.out.println(getCurrentThreadName() + " : Current Balance is Rs: "+balance);
            }
            else{
                System.out.println(getCurrentThreadName() + " : Insufficient Balance to withdraw :( ");
            }
            lock.unlock();
        }
        else{
            System.out.println(getCurrentThreadName() + " Not able to process !!");
        }
            
        
    }


    public String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }

}
