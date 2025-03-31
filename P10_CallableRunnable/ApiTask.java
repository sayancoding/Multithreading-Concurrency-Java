package P10_CallableRunnable;

import java.util.concurrent.Callable;

public class ApiTask implements Callable{


    private String apiName;

    public ApiTask(String name){
        apiName = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return (Thread.currentThread()+" : "+apiName + " has been called Successfully..");
    }
    
}