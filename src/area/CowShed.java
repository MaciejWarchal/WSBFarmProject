package area;

import java.awt.geom.Point2D;

public class CowShed extends Bulding{

    private int noumerOfCows;

    public CowShed(int number, Border border, Point2D center, double price, int noumerOfCows) {
        super(number, border, center, price);
        this.noumerOfCows = noumerOfCows;
    }
}
