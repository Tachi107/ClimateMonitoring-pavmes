package climatemonitoring.src;
public class ThreadDisappear implements Runnable{

    private boolean end;
    
    public void run() {
        end = true;
        while (end) {
            System.out.print("\010*");
            try {
                Thread.currentThread();
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void maskEnd() {
        this.end = false;
    }
}