package area;

public class MilkReceiver extends Bulding{

    private double milkCapacity;
    private double currentMilkLevel;

    public MilkReceiver(int number, Border border, double price, double milkCapacity, double currentMilkLevel) {
        super(number, border, price);
        this.milkCapacity = milkCapacity;
        this.currentMilkLevel = currentMilkLevel;
    }
}
