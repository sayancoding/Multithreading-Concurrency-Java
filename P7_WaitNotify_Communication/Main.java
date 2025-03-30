package P7_WaitNotify_Communication;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DataPacket dataPacket = new DataPacket();

        Runnable sender = () -> {
            String[] messages = {"hi", "hello", "welcome", "end"};

            for(String m : messages){
                dataPacket.producer(m);
                try {
                    Thread.sleep(new Random().nextInt(5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable receiver = () -> {

            do {
                dataPacket.consume();
                try {
                    Thread.sleep(new Random().nextInt(5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }while(true);
        };

        Thread senderThread = new Thread(sender,"Sender");
        Thread receiverThread = new Thread(receiver,"Receiver");

        senderThread.start();
        receiverThread.start();
    }
}
