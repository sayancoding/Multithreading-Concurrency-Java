package P9_ScheduleExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task(1);
        Task t2 = new Task(2);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(t1, 1, 4, TimeUnit.SECONDS); // choose large among period & task time
        executorService.scheduleWithFixedDelay(t2, 1, 4, TimeUnit.SECONDS);  // addition of period & task time

        
    }
}
