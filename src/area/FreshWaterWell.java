package area;
import system.Load;

import system.FileSystem;


import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FreshWaterWell extends Bulding implements centerable,checkBorder{

    private double waterproduction;
    private double waterCapacity;

    public FreshWaterWell() {
    }

    public FreshWaterWell(int number, Border border, double price, double waterproduction, double waterCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.waterproduction = waterproduction;
        this.waterCapacity = waterCapacity;
    }

    public static FreshWaterWell build(Farm farm){
        FreshWaterWell well;
        ArrayList<Object> buldingsR=new ArrayList<Object>();
        try {
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("buldings.bin"));
            buldingsR= (ArrayList<Object>) o.readObject();
            o.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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

            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                buldingsR.add(well);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e){
                e.printStackTrace();
            }

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
                ", waterproduction=" + waterproduction +
                ", waterCapacity=" + waterCapacity +
                '}';
    }



}
