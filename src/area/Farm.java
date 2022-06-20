package area;
import animals.Animal;
import humans.*;
import machines.Machine;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Farm {

    private String farmName;
    private String farmAddres;
    private Border FarmBorder;
    private Double cash;

    private ArrayList<Employee>employees;

    private ArrayList<Bulding>buildings;

    private List<Machine>machines;

    private List<Animal>animals;

    public Farm(String farmName, String farmAddres, Border farmBorder, Double cash) {
        this.farmName = farmName;
        this.farmAddres = farmAddres;
        this.FarmBorder = farmBorder;
        this.cash = cash;
    }

    public Border getFarmBorder() {
        return FarmBorder;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public static Border createFarmBorder(){
        System.out.println("nalezy okreslic granice nowej farmy w [m] (przyjmoje tylko wartosci dodatnie, farma ma ksztalt prostokatu");
        System.out.println("podaj polnocno-zachodni punkt graniczny");

        System.out.println("x ");
        double x1=getDouble();
        System.out.println("y ");
        double y1=getDouble();

        Point2D lu= new Point2D.Double(x1,y1);

        System.out.println("podaj polnocno-wschodni punkt graniczny");

        System.out.println("x ");
        double x2=getDouble();
        System.out.println("y ");
        double y2=getDouble();

        Point2D ru = new Point2D.Double(x2,y2);

        System.out.println("podaj poludniowo-zachodni punkt graniczny");

        System.out.println("x ");
        double x3=getDouble();
        System.out.println("y ");
        double y3=getDouble();

        Point2D ld = new Point2D.Double(x3,y3);

        System.out.println("podaj poludniowo-wschodni punkt graniczny");

        System.out.println("x ");
        double x4=getDouble();
        System.out.println("y ");
        double y4=getDouble();

        Point2D rd = new Point2D.Double(x4,y4);

        Border farm=new Border(lu,ru,ld,rd);

        return farm;
    }


    @Override
    public String toString() {
        return "Farm{" +
                "farmName='" + farmName + '\'' +
                ", farmAddres='" + farmAddres + '\'' +
                ", FarmBorder=" + FarmBorder +
                ", cash=" + cash +
                ", employees=" + employees +
                ", buildings=" + buildings +
                ", machines=" + machines +
                ", animals=" + animals +
                '}';
    }


    public static double getDouble(){
        return new Scanner(System.in).nextDouble();
    }


}




