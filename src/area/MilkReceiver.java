package area;

import java.awt.geom.Point2D;

public class MilkReceiver extends Bulding{

    private double milkCapacity;
    private double currentMilkLevel;

    public MilkReceiver(int number, Border border, Point2D center, double price, double milkCapacity, double currentMilkLevel) {
        super(number, border, center, price);
        this.milkCapacity = milkCapacity;
        this.currentMilkLevel = currentMilkLevel;
    }
}
