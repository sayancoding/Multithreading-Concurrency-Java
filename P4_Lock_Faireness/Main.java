package P4_Lock_Faireness;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource myResource = new Resource(true);

        Runnable task = ()->{
            myResource.accessResource();
        };
    
        for(int i = 0; i<5; i++){
            new Thread( task , ("Thread-"+i) ).start();
            Thread.sleep(2000);
        } 
    }
}
