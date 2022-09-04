package area;

import system.Deserialize;
import system.Load;
import system.Serialize;

import java.awt.geom.Point2D;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.*;
public class Field extends Bulding implements Serializable {

    private double grainProductionPerformance;
    private LocalDate startDate;
    private double area;
    private double massOfGrain;
    private LocalDate dateOfLastUpdate;
    public static final LocalDate beginingOfgrowing= LocalDate.of(1970,03,30);
    public static final LocalDate endOfGrowing= LocalDate.of(1970,8,28);


    public Field(int number, Border border, double price, double grainProductionPerformance) {
        super(number, border, centerable.findCenter(border), price);
        this.grainProductionPerformance = grainProductionPerformance;
        this.startDate = LocalDate.now();
        this.area = (border.getBorderPointRU().getX() - border.getBorderPointLU().getX()) * (border.getBorderPointLU().getY() - border.getBorderPointLD().getY());
        this.dateOfLastUpdate = LocalDate.now();


    }





    public static Field build(Farm FARM) {
        LocalDate nowDate = LocalDate.now();
        if (nowDate.getDayOfYear() > beginingOfgrowing.getDayOfYear()  && nowDate.getDayOfYear() < endOfGrowing.getDayOfYear()) {
            ArrayList<Object> buldingsL = new ArrayList<Object>();

            buldingsL = Deserialize.deserialize(buldingsL); //odczyt istniejących budynków

            System.out.println("podaj numer pola");
            int number = (Load.getInt());
            System.out.println("ustaw granice obiektu");
            Border border = new Border();
            border = Bulding.createBorder();
            if (border.checkBorder(FARM.getFarmBorder())) {
                System.out.println("obiekt ustawiono poprawnie");
                System.out.println("podaj koszt inwestycji");
                double price = getDouble();
                System.out.println("podaj ilosc produkowanego zboza w [(kg/m2)/rok]");
                double grainProductionPerformance = getDouble();


                Field field = new Field(number, border, price, grainProductionPerformance);
                buldingsL.add(field);
                Serialize.serialize(buldingsL);


                System.out.println("obiekt wybudowano");
                return field;

            } else {
                System.out.println("obietk po za granicami farmy");
                return null;

            }
        } else {
            System.out.println("w tym czasie nie wolno sadzić na polu!");
            return null;
        }

    }

    public void growing(){

        LocalDate dateNow= LocalDate.now();
        LocalDate period= LocalDate.ofEpochDay(ChronoUnit.DAYS.between(dateNow,dateOfConstruction));


    }

    public double getGrainProduction() {
        return grainProductionPerformance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getArea() {
        return area;
    }



    public double getMassOfGrain() {
        return massOfGrain;
    }

    public LocalDate getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public LocalDate getBeginingOfgrowing() {
        return beginingOfgrowing;
    }

    public LocalDate getEndOfGrowing() {
        return endOfGrowing;
    }

    public void setGrainProduction(double grainProduction) {
        this.grainProductionPerformance = grainProduction;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setArea(double area) {
        this.area = area;
    }



    public void setMassOfGrain(double massOfGrain) {
        this.massOfGrain = massOfGrain;
    }

    public void setDateOfLastUpdate(LocalDate dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }


    @Override
    public String toString() {
        return "Field{" +
                "grainProductionPerformance=" + grainProductionPerformance +
                ", startDate=" + startDate +
                ", area=" + area +
                ", massOfGrain=" + massOfGrain +
                ", dateOfLastUpdate=" + dateOfLastUpdate +
                ", number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                ", dateOfConstruction=" + dateOfConstruction +
                '}';
    }
}
