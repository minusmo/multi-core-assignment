import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {
    private final BlockingQueue q;
    public Consumer(BlockingQueue q) {
        this.q = q;
    }
    public void run() {
        while (true) {
            try {
                sleep((int)(Math.random() * 10000));
                System.out.println("Try to take an item out");
                q.take();
                System.out.println("Item is taken out.");
                System.out.println(q.size()+" items in");
            }
            catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}