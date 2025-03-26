package P1_Basic_Synchronization;

public class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " : Attempting to withdraw amount Rs: "+amount);
        
        synchronized(this){
            if(balance >= amount){
                System.out.println(Thread.currentThread().getName() + " : Processing withdraw amount Rs: "+amount);
                balance = balance - amount;
                Thread.sleep(5000); 
                System.out.println(Thread.currentThread().getName() + " : Withdraw has been successful :)");
                System.out.println(Thread.currentThread().getName() + " : Current Balance is Rs: "+balance);
            }
            else{
                System.out.println(Thread.currentThread().getName() + " : Insufficient Balance to withdraw :( ");
            }
        }
        
    }
    
}
