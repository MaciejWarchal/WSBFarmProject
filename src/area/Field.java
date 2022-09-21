package area;

import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Field extends Bulding implements Serializable {


    private double area_m2;
    private double performance_kgm2day;
    private double massOfGrain_kg;
    private LocalDate dateOfLastUpdate;


    public Field(int number, Border border, Point2D center, double price, double performance_kgm2day) {
        super(number, border, center, price);
        this.area_m2 =(border.getBorderPointRD().getY()-border.getBorderPointLU().getY())*(border.getBorderPointLU().getX()-border.getBorderPointLD().getX());
        this.performance_kgm2day = performance_kgm2day;
        this.massOfGrain_kg = 0;
        this.dateOfLastUpdate = LocalDate.now();
    }

    public static Field buildField(Farm farm, ArrayList buldingsL) {

        Field field=null;
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
                System.out.println("podaj wydajność z m2, sredno 0,1");
                double performance = getDouble();
                System.out.println("podaj pojemnosc studni w [m3]");
                double waterCapacity = getDouble();

                field = new Field(number,border,centerable.findCenter(border),price,performance);
                buldingsL.add(field);
                Serialize.serializationList(buldingsL, "buldings.bin");

                System.out.println("obiekt wybudowano");

            } else {
                System.out.println("obietk po za granicami farmy");
            }
        } else {
            System.out.println("podany numer budynku juz zajety, podaj nastepny numer");
        }
        return field;
    }

}
