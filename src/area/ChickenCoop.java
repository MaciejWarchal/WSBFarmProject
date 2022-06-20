package area;

import java.awt.geom.Point2D;

public class ChickenCoop extends Bulding{

    private int capacityOfChickens;
    private  int currentNumberOfChickens;

    public ChickenCoop(int number, Border border, Point2D center, double price, int capacityOfChickens, int currentNumberOfChickens) {
        super(number, border, center, price);
        this.capacityOfChickens = capacityOfChickens;
        this.currentNumberOfChickens = currentNumberOfChickens;
    }
}
