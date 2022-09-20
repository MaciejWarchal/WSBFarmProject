package area;

import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

public class FreshWaterWell extends Bulding implements centerable,checkBorder, Serializable {

    private double waterproduction;
    private double waterCapacity;

    public FreshWaterWell(int number, Border border, double price, double waterproduction, double waterCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.waterproduction = waterproduction;
        this.waterCapacity = waterCapacity;
    }

    public static FreshWaterWell buildFreshWatrWelll(Farm farm, ArrayList buldingsL) {

        FreshWaterWell well=null;
        System.out.println("podaj numer budynku");
        int number = Load.getInt();
        if (CheckNumbers.checkBuldingNumber(buldingsL, number)) {
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

                well = new FreshWaterWell(number, border, price, waterproduction, waterCapacity);
                buldingsL.add(well);
                Serialize.serializationList(buldingsL, "buldings.bin");

                System.out.println("obiekt wybudowano");

            } else {
                System.out.println("obietk po za granicami farmy");
            }
        } else {
            System.out.println("podany numer budynku juz zajety, podaj nastepny numer");
        }
        return well;
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
