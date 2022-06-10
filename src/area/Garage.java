package area;

import java.awt.geom.Point2D;

public class Garage extends Bulding{

    int numberOfParkingSpaces;

    public Garage(int number, Border border, double price, int numberOfParkingSpaces) {
        super(number, border, price);
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

}

