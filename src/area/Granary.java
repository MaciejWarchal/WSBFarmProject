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

        Granary granary = null;
        System.out.println("podaj numer pola lub budynku");
        int number = Load.getInt();


        if (!CheckNumbers.checkBuldingNumber(buldingsL, number)) {
            Granary.internalBuldingMethod(number, farm, granary, buldingsL);

        }else if (CheckNumbers.checkBuldingNumber(buldingsL,number)){
            System.out.println("buldingsL is empty="+buldingsL.isEmpty()+" numer zajety!"); //niech tak zostanie ale nie trzeba
            granary=null;
        }else {
            System.out.println("error");
        }
        return granary;
    }

        private static void internalBuldingMethod (int number,Farm farm, Granary granary, ArrayList buldingsL){

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

                granary = new Granary(number, border, centerable.findCenter(border), price, grainCapacity, grainLevel);
                buldingsL.add(granary);
                Serialize.serializationList(buldingsL, "buldings1.bin");

                System.out.println("obiekt wybudowano");

            } else {
                System.out.println("obietk po za granicami farmy");
            }
        }


        public double getGrainCapacity_kg () {
        return grainCapacity_kg;
        }


    public void setGrainCapacity_kg(double grainCapacity_kg) {
        this.grainCapacity_kg = grainCapacity_kg;
    }

    public double getGrainLevel_kg() {
        return grainLevel_kg;
    }

    public void setGrainLevel_kg(double grainLevel_kg) {
        this.grainLevel_kg = grainLevel_kg;
    }
}
