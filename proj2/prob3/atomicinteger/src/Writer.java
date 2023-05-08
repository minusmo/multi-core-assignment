import java.util.concurrent.atomic.AtomicInteger;

public class Writer extends Thread {
    private final AtomicInteger count;
    private final int id;
    public Writer(int id, AtomicInteger count) {
        super("writer "+id);
        this.id = id;
        this.count = count;
    }
    public void run() {
        while (true) {
            if (count.get() > 10) break;
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            System.out.println(getName()+" requests to write");
            System.out.println("Get and Add 2");
            System.out.println(count.getAndAdd(2));
            System.out.println("Set to 0");
            count.set(0);
            System.out.println("Add and Get 3");
            System.out.println(count.addAndGet(3));
            System.out.println(getName()+" writing finished");
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
        }
    }
}
