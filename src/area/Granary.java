package area;

import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Granary extends Bulding{

    private double grainCapacity_kg;
    public double grainLevel_kg;

    public Granary(int number, Border border, Point2D center, double price, double grainCapacity_kg, double grainLevel_kg) {
        super(number, border, center, price);
        this.grainCapacity_kg = grainCapacity_kg;
        this.grainLevel_kg = grainLevel_kg;
    }

    public static Granary buildGranary(Farm farm, ArrayList buldingsL) {

        Granary granary=null;
        System.out.println("podaj numer pola lub budynku");
        int number = Load.getInt();
        if (!CheckNumbers.checkBuldingNumber(buldingsL, number)) {
            System.out.println("ustaw granice obiektu");
            Border border = new Border();
            border = Bulding.createBorder();
            if (border.checkBorder(farm.getFarmBorder())) {
                System.out.println("obiekt ustawiono poprawnie");
                System.out.println("podaj koszt inwestycji");
                double price = getDouble();
                System.out.println("ppdaj pojemność spichlerza w [kg]");
                double grainCapacity = getDouble();
                System.out.println("podaj ilosc ziarna w spichlerzu");
                double grainLevel = getDouble();

                granary= new Granary(number,border,centerable.findCenter(border),price,grainCapacity,grainLevel);
                buldingsL.add(granary);
                Serialize.serializationList(buldingsL, "buldings.bin");

                System.out.println("obiekt wybudowano");

            } else {
                System.out.println("obietk po za granicami farmy");
            }
        } else {
            System.out.println("podany numer budynku juz zajety, podaj nastepny numer");
        }
        return granary;
    }
}
