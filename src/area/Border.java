package area;


import java.awt.geom.Point2D;

public class Border implements centerable {

    private Point2D BorderPointLU;    // // X i Y musi być dodatni trzeba będzie dodać zbezpiecznie!
    private Point2D BorderPointRU;
    private Point2D BorderPointLD;
    private Point2D BorderPointRD;



    public Border(Point2D borderPointLU, Point2D borderPointRU, Point2D borderPointLD, Point2D borderPointRD) {
        BorderPointLU = borderPointLU;
        BorderPointRU = borderPointRU;
        BorderPointLD = borderPointLD;
        BorderPointRD = borderPointRD;
    }

    public Point2D findCenter(Point2D borderPointLU, Point2D borderPointRU, Point2D borderPointLD,
                               Point2D borderPointRD){
        double[] farmBorderx={BorderPointLU.getX(),BorderPointRU.getX(),BorderPointLD.getX(),BorderPointRD.getX()};
        double[] farmBordery={BorderPointLU.getY(),BorderPointRU.getY(),BorderPointLD.getY(),BorderPointRD.getY()};

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

        double Xavg=avgt(Xmax,Xmin);
        double Yavg=avgt(Ymax,Ymin);
        Point2D center= new Point2D.Double(Xavg, Yavg);
        return center;

    }

    public static double avgt(double a, double b) {
        double avg;
        if(a>0&&b>0){
            avg=(a + b)/2;
        }
        else if (a<0&&b>0){
            avg=((Math.abs(a)+b)/2)-Math.abs(a);
        }
        else if (a>0&&b<0){
            avg=((a+Math.abs(b))/2)-Math.abs(b);
        }
        else {
            avg=((Math.abs(a) + Math.abs(b)) / 2) * -1;
        }
        return avg;
    }



    public void setBorderPointLU(Point2D borderPointLU) {
        BorderPointLU = borderPointLU;
    }

    public void setBorderPointRU(Point2D borderPointRU) {
        BorderPointRU = borderPointRU;
    }

    public void setBorderPointLD(Point2D borderPointLD) {
        BorderPointLD = borderPointLD;
    }

    public void setBorderPointRD(Point2D borderPointRD) {
        BorderPointRD = borderPointRD;
    }

    public Point2D getBorderPointLU() {
        return BorderPointLU;
    }

    public Point2D getBorderPointRU() {
        return BorderPointRU;
    }

    public Point2D getBorderPointLD() {
        return BorderPointLD;
    }

    public Point2D getBorderPointRD() {
        return BorderPointRD;
    }

    @Override
    public String toString() {
        return "Border{" +
                "BorderPointLU=" + BorderPointLU +
                ", BorderPointRU=" + BorderPointRU +
                ", BorderPointLD=" + BorderPointLD +
                ", BorderPointRD=" + BorderPointRD +
                '}';
    }
}

