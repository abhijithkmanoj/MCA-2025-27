abstract class Vehicle {
    String model;
    String company;

    Vehicle(String model, String company) {
        this.model = model;
        this.company = company;
    }

    abstract void display();
}

class Car extends Vehicle {
    int doors;
    String fuelType;

    Car(String model, String company, int doors, String fuelType) {
        super(model, company);
        this.doors = doors;
        this.fuelType = fuelType;
    }

    @Override
    void display() {
        System.out.println("Car Details:");
        System.out.println("Model: " + model);
        System.out.println("Company: " + company);
        System.out.println("Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Electric extends Car {
    int batteryCapacity;

    Electric(String model, String company, int doors,
             String fuelType, int batteryCapacity) {

        super(model, company, doors, fuelType);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void display() {
        System.out.println("Electric Car Details:");
        System.out.println("Model: " + model);
        System.out.println("Company: " + company);
        System.out.println("Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class car {
    public static void main(String[] args) {

        Vehicle v = new Electric("Model S", "Tesla",
                4, "Electric", 100);

        // Dynamic Method Dispatch
        v.display();
    }
}

