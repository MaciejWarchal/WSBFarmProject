package area;
import system.Load;

import system.FileSystem;
import system.Serialize;


import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FreshWaterWell extends Bulding implements centerable,checkBorder, Serializable {

    private double waterProductionPerDay;
    private double waterCapacity;

    public FreshWaterWell() {
    }

    public FreshWaterWell(int number, Border border, double price, double waterProductionPerDay, double waterCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.waterProductionPerDay = waterProductionPerDay;
        this.waterCapacity = waterCapacity;

    }



    public static FreshWaterWell build(Farm farm, ArrayList buldingsL){
        FreshWaterWell well;


        System.out.println("podaj numer budynku");
        int number=Load.getInt();
        System.out.println("ustaw granice obiektu");
        Border border=new Border();
        border=Bulding.createBorder();
        if (border.checkBorder(farm.getFarmBorder())){
            System.out.println("obiekt ustawiono poprawnie");
            System.out.println("podaj koszt inwestycji");
            double price=getDouble();
            System.out.println("podaj ilosc wody wytwarzanej na dzien w [m3]");
            double waterproduction=getDouble();
            System.out.println("podaj pojemnosc studni w [m3]");
            double waterCapacity=getDouble();

            well=new FreshWaterWell(number,border,price,waterproduction,waterCapacity);
            buldingsL.add(well);
            Serialize.serialize(buldingsL);

            System.out.println("obiekt wybudowano");
            return well;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;
        }

    }

    @Override
    public String toString() {
        return "FreshWaterWell{" +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                ", waterproduction=" + waterProductionPerDay +
                ", waterCapacity=" + waterCapacity +
                '}';
    }



}
