package area;

public class Granary extends Bulding{

    private double grainCapacity;
    public double grainLevel;

    public Granary(int number, Border border, double price, double grainCapacity, double grainLevel) {
        super(number, border, price);
        this.grainCapacity = grainCapacity;
        this.grainLevel = grainLevel;
    }


}
