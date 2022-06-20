package area;

import java.awt.geom.Point2D;

public class FreshWaterWell extends Bulding implements centerable,checkBorder{

    private double waterproduction;
    private double waterCapacity;

    public FreshWaterWell(int number, Border border, double price, double waterproduction, double waterCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.waterproduction = waterproduction;
        this.waterCapacity = waterCapacity;
    }

    @Override
    public String toString() {
        return "FreshWaterWell{" +
                "waterproduction=" + waterproduction +
                ", waterCapacity=" + waterCapacity +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }



}
