package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;

public class Field extends Bulding implements Serializable {

    private double grainProduction;


    public Field(int number, Border border, double price, double grainProduction) {
        super(number, border, centerable.findCenter(border), price);
        this.grainProduction = grainProduction;
    }

    public static Field build(Farm FARM) {
        ArrayList<Object> buldingsR = new ArrayList<Object>();
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("buldings.bin"));
            buldingsR = (ArrayList<Object>) o.readObject();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("podaj numer pola");
        int number = (Load.getInt());
        System.out.println("ustaw granice obiektu");
        Border border = new Border();
        border = Bulding.createBorder();
        if (border.checkBorder(FARM.getFarmBorder())) {
            System.out.println("obiekt ustawiono poprawnie");
            System.out.println("podaj koszt inwestycji");
            double price = getDouble();
            System.out.println("podaj ilosc produkowanego zboza w [t]");
            double grainproduction = getDouble();


            Field field = new Field(number, border, price, grainproduction);

            try {
                ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("buldings.bin", false));
                buldingsR.add(field);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("obiekt wybudowano");
            return field;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;

        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "grainProduction=" + grainProduction +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }
}
