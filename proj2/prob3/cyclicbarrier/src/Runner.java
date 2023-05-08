import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Runner extends Thread {
    private final int id;
    private final CyclicBarrier cbarrier1;
    private final CyclicBarrier cbarrier2;

    public Runner(int i, CyclicBarrier cbarrier1, CyclicBarrier cbarrier2) {
        super(i+"th runner");
        this.id = i;
        this.cbarrier1 = cbarrier1;
        this.cbarrier2 = cbarrier2;
    }
    public void run() {
        try {
            sleep((long)Math.random()*10000000);
            System.out.println(getName()+" starts running");
            sleep((long)Math.random()*10000000 + 3000l);
            System.out.println(getName()+" finished a round");
            cbarrier1.await();
            sleep((long)Math.random()*10000000);
            System.out.println(getName()+" starts running again");
            sleep((long)Math.random()*10000000 + 3000l);
            System.out.println(getName()+" finished another round");
            cbarrier2.await();
        }
        catch (InterruptedException e) {}
        catch (BrokenBarrierException e) {}

    }
}
