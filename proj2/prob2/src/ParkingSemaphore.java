import java.util.concurrent.Semaphore;

class ParkingGarageSemaphore {
    private int places;
    private Semaphore parkingGarage;
    public ParkingGarageSemaphore(int places) {
        if (places < 0)
            places = 0;
        this.places = places;
        this.parkingGarage = new Semaphore(places);
    }
    public void enter() { // enter parking garage
        try {
            parkingGarage.acquire();
            places--;

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void leave() { // leave parking garage
        places++;
        parkingGarage.release();
    }
    public int getPlaces()
    {
        return places;
    }
}


class Car extends Thread {
    private ParkingGarageSemaphore parkingGarage;
    public Car(String name, ParkingGarageSemaphore p) {
        super(name);
        this.parkingGarage = p;
        start();
    }

    private void tryingEnter()
    {
        System.out.println(getName()+": trying to enter");
    }


    private void justEntered()
    {
        System.out.println(getName()+": just entered");

    }

    private void aboutToLeave()
    {
        System.out.println(getName()+":                                     about to leave");
    }

    private void Left()
    {
        System.out.println(getName()+":                                     have been left");
    }

    public void run() {
        while (true) {
            try {
                sleep((int)(Math.random() * 10000)); // drive before parking
            } catch (InterruptedException e) {}
            tryingEnter();
            parkingGarage.enter();
            justEntered();
            try {
                sleep((int)(Math.random() * 20000)); // stay within the parking garage
            } catch (InterruptedException e) {}
            aboutToLeave();
            parkingGarage.leave();
            Left();
        }
    }
}