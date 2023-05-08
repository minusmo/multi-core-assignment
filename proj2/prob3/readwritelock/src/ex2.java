import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ex2 {
    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Stack<Integer> stk = new Stack<Integer>();
        int nOfWriters = 3;
        Thread[] writers = new Thread[nOfWriters];
        for (int i=0;i<nOfWriters;i++) {
            writers[i] = new Writer(i, rwLock, stk);
            writers[i].start();
        }
        Thread reader = new Reader(rwLock, stk);
        reader.start();
        try {
            for (int i=0;i<nOfWriters;i++) {
                writers[i].join();
            }
            reader.join();
        } catch (InterruptedException e) {}
    }
}
