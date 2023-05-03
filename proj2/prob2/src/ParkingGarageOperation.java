public class ParkingGarageOperation {
    public static void main(String[] args){
        ParkingGarageSemaphore parkingGarage = new ParkingGarageSemaphore(7);
        for (int i=1; i<= 10; i++) {
            Car c = new Car("Car "+i, parkingGarage);
        }
    }
}