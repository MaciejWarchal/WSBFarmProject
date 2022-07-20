package area;

import system.Load;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;

public class ChickenCoop extends Bulding implements Serializable {

    private int amoutOfChickens;
    private  int currentNumberOfChickens;

    public ChickenCoop(int number, Border border, double price, int capacityOfChickens, int currentNumberOfChickens) {
        super(number, border,centerable.findCenter(border) ,price);
        this.amoutOfChickens = capacityOfChickens;
        this.currentNumberOfChickens = currentNumberOfChickens;
    }

    public static ChickenCoop build(Farm farm){
        ChickenCoop chickenCoop;
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
            System.out.println("podaj pojemność kurnika");
            int capacityOfChickenCoop=Load.getInt();
            System.out.println("podaj ilolość zwierząt");
            int quantityOfChickens=Load.getInt();

            chickenCoop= new ChickenCoop(number,border,price,capacityOfChickenCoop,quantityOfChickens);

            try {
                ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("buldings.bin",false));
                buldingsR.add(chickenCoop);
                o.writeObject(buldingsR);
                o.close();

            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("obiekt wybudowano");
            return chickenCoop;

        } else {
            System.out.println("obietk po za granicami farmy");
            return null;
        }

    }
}

