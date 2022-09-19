package area;

import system.Load;

import java.awt.geom.Point2D;

public class FreshWaterWell extends Bulding implements centerable,checkBorder{

    private double waterproduction;
    private double waterCapacity;

    public FreshWaterWell(int number, Border border, double price, double waterproduction, double waterCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.waterproduction = waterproduction;
        this.waterCapacity = waterCapacity;
    }

    public static FreshWaterWell buildFreshwatrWelll(Farm farm) {
        System.out.println("podaj numer budynku");
        int number = Load.getInt();
        System.out.println("ustaw granice obiektu");
        Border border = new Border();
        border = Bulding.createBorder();
        if (border.checkBorder(farm.getFarmBorder())) {
            System.out.println("obiekt ustawiono poprawnie");
            System.out.println("podaj koszt inwestycji");
            double price = getDouble();
            System.out.println("podaj ilosc wody wytwarzanej na dzien w [m3]");
            double waterproduction = getDouble();
            System.out.println("podaj pojemnosc studni w [m3]");
            double waterCapacity = getDouble();

            FreshWaterWell well = new FreshWaterWell(number, border, price, waterproduction, waterCapacity);
            System.out.println("obiekt wybudowano");

        } else {
            System.out.println("obietk po za granicami farmy");
        }
    }
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
