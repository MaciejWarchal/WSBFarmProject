package area;

import java.awt.geom.Point2D;

public class Granary extends Bulding{

    private double grainCapacity;
    public double grainLevel;

    public Granary(int number, Border border, Point2D center, double price, double grainCapacity, double grainLevel) {
        super(number, border, center, price);
        this.grainCapacity = grainCapacity;
        this.grainLevel = grainLevel;
    }
}
