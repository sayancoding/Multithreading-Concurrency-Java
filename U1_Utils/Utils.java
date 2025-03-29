package U1_Utils;

public class Utils {
    private Utils(){};

    public static void print(String msg, Object ...args){
        msg = msg.replaceAll("\\{}", "%s");
        msg += "\n";
        System.out.printf(msg,args);
        
    }

    public static String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }
}
