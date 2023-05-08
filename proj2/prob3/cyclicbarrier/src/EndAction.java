public class EndAction implements Runnable {
    private final int order;
    public EndAction(int order) {
        this.order = order;
    }
    public void run() {
        System.out.println(order+"th round is end.");
    }
}
