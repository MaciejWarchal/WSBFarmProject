package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;

public class MilkReceiver extends Bulding implements Serializable {

    private double milkCapacity;
    private double currentMilkLevel;

    public MilkReceiver(int number, Border border, double price, double milkCapacity, double currentMilkLevel) {
        super(number, border, centerable.findCenter(border), price);
        this.milkCapacity = milkCapacity;
        this.currentMilkLevel = currentMilkLevel;
    }
    public static MilkReceiver build(Farm farm){
        MilkReceiver milkReceiver;
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
        if (border.checkBorder(farm.getFarmBorder())){
            System.out.println("obiekt ustawiono poprawnie");
            System.out.println("podaj koszt inwestycji");
            double price=getDouble();
            System.out.println("podaj ilość mleka w zbiorniku [m3]");
            double amoutOfMilkInReceiver=getDouble();
            System.out.println("podaj pojemnosc zbiornika [m3]");
            double milkCapacity=getDouble();

            milkReceiver=new MilkReceiver(number,border,price,milkCapacity,amoutOfMilkInReceiver);

            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                buldingsR.add(milkReceiver);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("obiekt wybudowano");
            return milkReceiver;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;
        }

    }


    @Override
    public String toString() {
        return "MilkReceiver{" +
                "milkCapacity=" + milkCapacity +
                ", currentMilkLevel=" + currentMilkLevel +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }
}
