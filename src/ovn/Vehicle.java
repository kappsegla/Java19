package ovn;

public class Vehicle {

    private String model = "";
    private int passengers;
    private int fuelCap;
    private float mpg;
    private boolean spareWheel;

    public Vehicle(String model, int passengers, int fuelCap, float mpg) {
        this.model = model;
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
    }

    public Vehicle(String model, int passengers, int fuelCap, float mpg, boolean spareWheel) {
        this.model = model;
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
        this.spareWheel = spareWheel;
    }

    public float computeRange(){
        return fuelCap * mpg;
    }

    public String getModel() {
        return model;
    }

    public boolean isSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(boolean spareWheel) {
        this.spareWheel = spareWheel;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public float getMpg() {
        return mpg;
    }

    public void setMpg(float mpg) {
        this.mpg = mpg;
    }
}
