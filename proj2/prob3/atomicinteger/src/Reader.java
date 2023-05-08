import java.util.concurrent.atomic.AtomicInteger;

public class Reader extends Thread {
    private final AtomicInteger count;
    public Reader(AtomicInteger count) {
        this.count = count;
    }
    public void run() {
        while (true) {
            if (count.get() > 10) break;
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            System.out.println("Requests to read");
            System.out.println(count.get());
            System.out.println("Reading finished");
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
        }
    }
}
