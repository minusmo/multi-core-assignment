import java.util.concurrent.CyclicBarrier;

public class ex4 {
    public static void main(String[] args) {
        Runnable endAction1 = new EndAction(1);
        Runnable endAction2 = new EndAction(2);
        CyclicBarrier cbarrier1 = new CyclicBarrier(10, endAction1);
        CyclicBarrier cbarrier2 = new CyclicBarrier(10, endAction2);
        int nOfRunners = 10;
        Thread[] runners = new Thread[nOfRunners];
        for (int i=0;i<nOfRunners;i++) {
            runners[i] = new Runner(i,cbarrier1, cbarrier2);
            runners[i].start();
        }
    }
}