package P5_ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        MyCounter counter = new MyCounter();

        Thread writeThread = new Thread(()->{
            for(int i = 0; i<10;i++){
                try {
                    counter.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Write-Thread");

        Thread readThread1 = new Thread(()->{
            for(int i = 0; i<10;i++){
                try {
                    counter.viewCounterValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Read-Thread-1");

        Thread readThread2 = new Thread(()->{
            for(int i = 0; i<10;i++){
                try {
                    counter.viewCounterValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Read-Thread-2");

        writeThread.start();
        readThread1.start();
        readThread2.start();
    }
}
