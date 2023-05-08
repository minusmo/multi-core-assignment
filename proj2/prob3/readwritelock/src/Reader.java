import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;

public class Reader extends Thread {
    private final ReadWriteLock rwLock;
    private final Stack<Integer> stk;
    public Reader(ReadWriteLock rwLock, Stack<Integer> stk) {
        this.rwLock = rwLock;
        this.stk = stk;
    }
    public void run() {
        while (true) {
            if (stk.size() > 10) break;
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            System.out.println("Requests to read");
            rwLock.readLock().lock();
            System.out.println("Lock acquired for reading");
            if (stk.size() != 0)
                System.out.println(stk.peek());
            System.out.println("Reading finished");
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            rwLock.readLock().unlock();
            System.out.println("Lock released for reading");
        }
    }
}
