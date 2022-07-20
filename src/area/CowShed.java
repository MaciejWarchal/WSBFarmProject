package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;

public class CowShed extends Bulding implements Serializable {

    private int currentNoumerOfCows;
    private int maxCowsCapacity;

    public CowShed(int currentNoumerOfCows, int maxCowsCapacity) {
        this.currentNoumerOfCows = currentNoumerOfCows;
        this.maxCowsCapacity = maxCowsCapacity;
    }

    public CowShed(int number, Border border, double price, int currentNoumerOfCows, int maxCowsCapacity) {
        super(number, border, centerable.findCenter(border), price);
        this.currentNoumerOfCows = currentNoumerOfCows;
        this.maxCowsCapacity = maxCowsCapacity;
    }

    public static CowShed build(Farm farm){
        CowShed cowShed;
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
            System.out.println("podaj obecną ilosc krow");
            int currentAmoutOfCows=Load.getInt();
            System.out.println("podaj maksymalna ilosc krow przechowywana");
            int maxAmoutOfCows=Load.getInt();

            cowShed= new CowShed(number,border,price,currentAmoutOfCows,maxAmoutOfCows);

            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                buldingsR.add(cowShed);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("obiekt wybudowano");
            return cowShed;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;
        }

    }
}
