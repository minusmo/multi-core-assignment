import java.util.concurrent.ArrayBlockingQueue;

class ParkingGarageBlockingQueue {
    private int places;
    private ArrayBlockingQueue<String> parkingGarage;
    public ParkingGarageBlockingQueue(int places) {
        if (places < 0)
            places = 0;
//        this.places = places;
        this.parkingGarage = new ArrayBlockingQueue<String>(places);
    }
    public void enter(String carName) { // enter parking garage
        try {
            parkingGarage.put(carName);
//            places--;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void leave() { // leave parking garage
        try {
            String leftingCar = (String)parkingGarage.take();
//            places++;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getPlaces()
    {
        return parkingGarage.size();
    }
}


class Car extends Thread {
    private ParkingGarageBlockingQueue parkingGarage;
    public Car(String name, ParkingGarageBlockingQueue p) {
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
            parkingGarage.enter(getName());
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

