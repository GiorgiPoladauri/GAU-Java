// HomeWork1.java Giorgi Poladauri

// 1. აბსტრაქტული კლასი Transport
abstract class Transport {
    protected String brand;
    protected double speed;

    // კონსტრუქტორი
    public Transport(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // აბსტრაქტული მეთოდი
    public abstract void move();

    // ჩვეულებრივი მეთოდი
    public void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// 2. ინტერფეისი Fuel
interface Fuel {
    void fuelType();
}

// 3. კლასი Car
class Car extends Transport implements Fuel {
    private int doors;

    // კონსტრუქტორი
    public Car(String brand, double speed, int doors) {
        super(brand, speed);
        this.doors = doors;
    }

    // move() მეთოდი
    @Override
    public void move() {
        System.out.println("Car is moving on the road...");
    }

    // fuelType() მეთოდი
    @Override
    public void fuelType() {
        System.out.println("Fuel type: Petrol");
    }

    // showInfo() მეთოდის გაფართოება
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Doors: " + doors);
    }
}

// 4. მთავარი კლასი main() მეთოდით
public class HomeWork1 {
    public static void main(String[] args) {

        // ობიექტის შექმნა
        Car car1 = new Car("Toyota", 180, 4);

        // მეთოდების გამოძახება
        car1.showInfo();
        car1.move();
        car1.fuelType();
    }
}
