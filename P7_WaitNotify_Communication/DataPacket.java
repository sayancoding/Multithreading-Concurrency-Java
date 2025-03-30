package P7_WaitNotify_Communication;

import static U1_Utils.Utils.*;

public class DataPacket {
    private String data;
    private boolean hasData;

    public String getData (){return data;}

    public synchronized void producer(String msg){
        while(hasData == true){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        //Sending process
        print("{} : Producing data : {}", getCurrentThreadName(),msg);
        this.data = msg;
        hasData = true;
        notify();
    }

    public synchronized void consume(){
        while(hasData == false){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        print("{} : Consuming data : {}", getCurrentThreadName(),data);
        hasData = false;
        data = null;
        notify();
    }
}
