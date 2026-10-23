import java.util.Scanner;

public class Car {

    private String brand;
    private String model;
    private int year;
    private String color;
    private double mileage;
    private double fuelLevel;
    private boolean engineOn;

    // Default constructor
    public Car() {
        brand = "Unknown";
        model = "Unknown";
        year = 0;
        color = "Unknown";
        mileage = 0;
        fuelLevel = 0;
        engineOn = false;
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, String color,
               double mileage, double fuelLevel, boolean engineOn) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.fuelLevel = fuelLevel;
        this.engineOn = engineOn;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getMileage() {
        return mileage;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    // Start engine
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("The engine has started.");
        } else {
            System.out.println("The engine is already running.");
        }
    }

    // Stop engine
    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("The engine has stopped.");
        } else {
            System.out.println("The engine is already off.");
        }
    }

    // Drive the car
    public void drive(double distance) {
        if (distance <= 0) {
            System.out.println("Distance must be more than 0.");
        } else if (!engineOn) {
            System.out.println("Start the engine first.");
        } else if (fuelLevel <= 0) {
            System.out.println("No fuel left.");
        } else {
            double fuelNeeded = distance * 0.08;

            if (fuelNeeded > fuelLevel) {
                double possibleDistance = fuelLevel / 0.08;

                mileage = mileage + possibleDistance;
                fuelLevel = 0;

                System.out.println("The car ran out of fuel.");
            } else {
                mileage = mileage + distance;
                fuelLevel = fuelLevel - fuelNeeded;

                System.out.println("The car drove " + distance + " km.");
            }
        }
    }

    // Refuel the car
    public void refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Fuel amount must be more than 0.");
        } else {
            fuelLevel = fuelLevel + amount;

            if (fuelLevel > 100) {
                fuelLevel = 100;
            }

            System.out.println("Fuel level: " + fuelLevel + "%");
        }
    }

    // Show car information
    public void displayInfo() {
        System.out.println("\n--- Car Information ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Mileage: " + mileage + " km");
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("Engine On: " + engineOn);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a car:");
        System.out.println("1. Proton Saga");
        System.out.println("2. Perodua Myvi");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        Car car;

        if (choice == 1) {
            car = new Car(
                "Proton",
                "Saga",
                2022,
                "White",
                0,
                100,
                false
            );

        } else if (choice == 2) {
            car = new Car(
                "Perodua",
                "Myvi",
                2022,
                "Red",
                0,
                100,
                false
            );

        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        car.displayInfo();

        System.out.println(
            "\nSelected car: " + car.getBrand() + " " + car.getModel()
        );

        // Setter example
        car.setColor("Black");

        System.out.println("New color: " + car.getColor());

        System.out.print("\nStart engine? 1 = Yes, 0 = No: ");
        int start = scanner.nextInt();

        if (start == 1) {

            car.startEngine();

            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter distance to drive: ");
                double distance = scanner.nextDouble();

                car.drive(distance);
            }

            System.out.print("Enter fuel amount to add: ");
            double fuel = scanner.nextDouble();

            car.refuel(fuel);

        } else {
            System.out.println("Engine remains off.");
        }

        car.displayInfo();
        car.stopEngine();

        scanner.close();
    }
}
