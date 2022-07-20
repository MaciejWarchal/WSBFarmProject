package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Granary extends Bulding{

    private double grainCapacity;
    private double amoutOfGrain;

    public Granary(int number, Border border, double price, double grainCapacity, double amoutOfGrain) {
        super(number, border, centerable.findCenter(border), price);
        this.grainCapacity = grainCapacity;
        this.amoutOfGrain = amoutOfGrain;
    }

    public static Granary build(Farm FARM){
        ArrayList<Object> buldingsR=new ArrayList<Object>();
        try {
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("buldings.bin"));
            buldingsR= (ArrayList<Object>) o.readObject();
            o.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("podaj numer budynku");
        int number= Load.getInt();
        System.out.println("ustaw granice obiektu");
        Border border=new Border();
        border=Bulding.createBorder();
        if (border.checkBorder(FARM.getFarmBorder())){
            System.out.println("obiekt ustawiono poprawnie");
            System.out.println("podaj koszt inwestycji");
            double price=getDouble();
            System.out.println("podaj pojemnosc spichlerza [t]");
            double capacity=getDouble();



            Granary granary =new Granary(number,border,price,capacity,0.0);
            buldingsR.add(granary);
            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                o.writeObject(buldingsR);
                o.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("obiekt wybudowano");
            return granary;
        } else {
            System.out.println("obietk po za granicami farmy");
            return null;

        }
    }

    @Override
    public String toString() {
        return "Granary{" +
                "grainCapacity=" + grainCapacity +
                ", amoutOfGrain=" + amoutOfGrain +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }
}
