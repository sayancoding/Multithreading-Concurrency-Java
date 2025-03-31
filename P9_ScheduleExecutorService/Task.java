package P9_ScheduleExecutorService;

import static U1_Utils.Utils.*;

import java.time.LocalDateTime;

public class Task implements Runnable {

    private int serialNo;

    public Task(int no){
        serialNo = no;
    }

    @Override
    public void run() {
        print("{} :: Task-{} is executing at {} ", getCurrentThreadName(),serialNo,LocalDateTime.now().toLocalTime().toString());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
