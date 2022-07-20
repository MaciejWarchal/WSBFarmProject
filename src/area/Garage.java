package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;

public class Garage extends Bulding implements Serializable {

    int quantityOfVehicles;


    public Garage(int number, Border border, double price, int quantityOfVehicles) {
        super(number, border, centerable.findCenter(border), price);
        this.quantityOfVehicles = quantityOfVehicles;
    }

    public static Garage build(Farm farm){
        Garage garage;
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
            System.out.println("podaj ilolość maszyn mogacych parkować");
            int quantityOfVehicles=Load.getInt();


            garage= new Garage(number,border,price,quantityOfVehicles);

            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                buldingsR.add(garage);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("obiekt wybudowano");
            return garage;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;
        }

    }

    @Override
    public String toString() {
        return "Garage{" +
                "quantityOfVehicles=" + quantityOfVehicles +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }
}

