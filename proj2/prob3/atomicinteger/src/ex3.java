import java.util.concurrent.atomic.AtomicInteger;

public class ex3 {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        int nOfWriters = 3;
        Thread[] writers = new Thread[nOfWriters];
        for (int i=0;i<nOfWriters;i++) {
            writers[i] = new Writer(i, count);
            writers[i].start();
        }
        Thread reader = new Reader(count);
        reader.start();
        try {
            for (int i=0;i<nOfWriters;i++) {
                writers[i].join();
            }
            reader.join();
        } catch (InterruptedException e) {}
    }
}