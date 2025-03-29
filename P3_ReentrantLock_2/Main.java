package P3_ReentrantLock_2;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(()->{
            try {
                account.deposit(100);
                account.withdraw(80);
                account.performTransaction(100, 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread A");

        Thread t2 = new Thread(()->{
            try {
                account.performTransaction(100, 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread B");

        t1.start();
        t2.start();
    }
     
}
