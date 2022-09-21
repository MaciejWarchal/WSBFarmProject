package area;

import machines.Machine;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Garage extends Bulding{

    private int numberOfParkingSpaces;

    private ArrayList<Machine> parkingMachines;

    public Garage(int number, Border border, Point2D center, double price, int numberOfParkingSpaces) {
        super(number, border, center, price);
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }
}

