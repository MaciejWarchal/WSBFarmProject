package area;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Bulding implements centerable,checkBorder, Serializable {

    protected int number;
    protected Border border;
    protected Point2D center;
    protected double price;

    public Border getBorder() {
        return this.border;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public Bulding(int number, Border border, Point2D center, double price) {
        this.number = number;
        this.border = border;
        this.center = center;
        this.price = price;
    }

    public Bulding() {
    }

    public boolean checkBorder(Border farmBorder, Border thisBorder){

            double[] farmBorderx={farmBorder.getBorderPointLU().getX(),farmBorder.getBorderPointRU().getX(),
                    farmBorder.getBorderPointLD().getX(),farmBorder.getBorderPointRD().getX()};
            double[] farmBordery={farmBorder.getBorderPointLU().getY(),farmBorder.getBorderPointRU().getY(),
                    farmBorder.getBorderPointRD().getY(),farmBorder.getBorderPointLD().getY()};
            double[] thisBorderx={thisBorder.getBorderPointLU().getX(),thisBorder.getBorderPointRU().getX(),
                    thisBorder.getBorderPointLD().getX(),thisBorder.getBorderPointRD().getX()};
            double[] thisBordery={thisBorder.getBorderPointLU().getY(),thisBorder.getBorderPointRU().getY(),
                    thisBorder.getBorderPointLD().getY(),thisBorder.getBorderPointRD().getY()};

            double Xmax=farmBorderx[0];
            for (int i=1;i<4;i++){
                if (farmBorderx[i]>Xmax){
                    Xmax=farmBorderx[i];
                }
            }

            double Xmin=farmBorderx[0];
            for (int i=1;i<4;i++){
                if (farmBorderx[i]<Xmin){
                    Xmin=farmBorderx[i];
                }
            }

            double Ymax=farmBordery[0];
            for (int i=1;i<4;i++){
                if (farmBordery[i]>Ymax){
                    Ymax=farmBorderx[i];
                }
            }

            double Ymin=farmBordery[0];
            for (int i=1;i<4;i++){
                if (farmBordery[i]<Ymin){
                    Ymin=farmBordery[i];
                }
            }

            if     ((this.border.getBorderPointLU().getX()<Xmin || this.border.getBorderPointLU().getX()>Xmax)||
                    (this.border.getBorderPointLU().getY()<Ymin || this.border.getBorderPointLU().getY()>Ymax)||
                    (this.border.getBorderPointRU().getX()<Xmin || this.border.getBorderPointRU().getX()>Xmax)||
                    (this.border.getBorderPointRU().getY()<Ymin || this.border.getBorderPointRU().getY()>Ymax)||
                    (this.border.getBorderPointLD().getX()<Xmin || this.border.getBorderPointLD().getX()>Xmax)||
                    (this.border.getBorderPointLD().getY()<Ymin || this.border.getBorderPointLD().getY()>Ymax)||
                    (this.border.getBorderPointRD().getX()<Xmin || this.border.getBorderPointRD().getX()>Xmax)||
                    (this.border.getBorderPointRD().getY()<Ymin || this.border.getBorderPointRD().getY()>Ymax))
            {
            throw new IndexOutOfBoundsException("obiekt po za granicami farmy");
            } else {
            return true;
            }
    }

    public static Border createBorder(){
        System.out.println("nalezy okreslic granice nowego budynku w [m] (budynek zawsze ma ksztalt prostokatu");
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public Point2D getCenter() {
        return center;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bulding{" +
                "number=" + number +
                ", border=" + border +
                ", center=" + center +
                ", price=" + price +
                '}';
    }

    public static double getDouble(){
        return new Scanner(System.in).nextDouble();
    }
}





