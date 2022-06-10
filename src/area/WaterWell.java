package area;

public class WaterWell extends Bulding{

    private double waterproduction;
    private double waterCapacity;

    public WaterWell(int number, Border border, double price, double waterproduction, double waterCapacity) {
        super(number, border, price);
        this.waterproduction = waterproduction;
        this.waterCapacity = waterCapacity;
    }
}
