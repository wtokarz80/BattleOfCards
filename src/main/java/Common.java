public class Common {



    public static void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
