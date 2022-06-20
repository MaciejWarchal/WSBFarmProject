package area;

import java.awt.geom.Point2D;

public class Garage extends Bulding{

    int numberOfParkingSpaces;

    public Garage(int number, Border border, Point2D center, double price, int numberOfParkingSpaces) {
        super(number, border, center, price);
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }
}

