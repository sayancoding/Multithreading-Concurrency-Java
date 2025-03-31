package P10_CallableRunnable;

import static U1_Utils.Utils.getCurrentThreadName;
import static U1_Utils.Utils.print;

public class EmailTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        print("{} :: Email has been triggered", getCurrentThreadName());
    }
    
}
