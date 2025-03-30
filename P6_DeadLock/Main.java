package P6_DeadLock;

import static U1_Utils.Utils.print;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Thread t1 = new Thread(()->{
            try {
                resource.access1();
                // resource.access2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        },"Thread-A");

        Thread t2 = new Thread(()->{
            try {
                resource.access2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        },"Thread-B");

        t1.start();
        t2.start();
    }
}
