import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;

public class Writer extends Thread {
    private final ReadWriteLock rwLock;
    private final Stack<Integer> stk;
    private final int id;
    public Writer(int id, ReadWriteLock rwLock, Stack<Integer> stk) {
        super("writer "+id);
        this.id = id;
        this.rwLock = rwLock;
        this.stk = stk;
    }
    public void run() {
        while (true) {
            if (stk.size() > 10) break;
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            System.out.println(getName()+" requests to write");
            rwLock.writeLock().lock();
            System.out.println(getName()+" lock acquired for writing");
            stk.push(stk.size()+1);
            System.out.println(getName()+" writing finished");
            try {
                sleep((long)Math.random()*10000000 + 3000l);
            } catch (InterruptedException e) {}
            rwLock.writeLock().unlock();
            System.out.println(getName()+" lock released writing");
        }
    }
}
