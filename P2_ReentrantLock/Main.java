package P2_ReentrantLock;

public class Main {
    public static void main(String[] args) {
                BankAccount bankAccount = new BankAccount();
        Thread person1 = new Thread(()->{
            try {
                bankAccount.withdraw(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Ram");
        Thread person2 = new Thread(()->{
            try {
                bankAccount.withdraw(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Sham");

        person1.start();
        person2.start();
    }
}
