import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
    private final BlockingQueue q;
    public Producer(BlockingQueue q) {
        this.q = q;
    }
    public void run() {
        while (true) {
            try {
                sleep((int)(Math.random() * 10000));
                System.out.println("Try to put an item");
                q.put("item");
                System.out.println("Item is put in.");
                System.out.println(q.size()+" items in");
            }
            catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}