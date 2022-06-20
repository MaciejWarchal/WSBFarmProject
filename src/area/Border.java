package area;


import java.awt.geom.Point2D;

public class Border {

    private Point2D BorderPointLU;
    private Point2D BorderPointRU;
    private Point2D BorderPointLD;
    private Point2D BorderPointRD;

    public Border() {
    }

    public Border(Point2D borderPointLU, Point2D borderPointRU, Point2D borderPointLD, Point2D borderPointRD) {
        BorderPointLU = borderPointLU;
        BorderPointRU = borderPointRU;
        BorderPointLD = borderPointLD;
        BorderPointRD = borderPointRD;
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
    public boolean checkBorder(Border farmBorder){

        double[] farmBorderx={farmBorder.getBorderPointLU().getX(),farmBorder.getBorderPointRU().getX(),
                farmBorder.getBorderPointLD().getX(),farmBorder.getBorderPointRD().getX()};
        double[] farmBordery={farmBorder.getBorderPointLU().getY(),farmBorder.getBorderPointRU().getY(),
                farmBorder.getBorderPointRD().getY(),farmBorder.getBorderPointLD().getY()};
        double[] thisBorderx={this.getBorderPointLU().getX(),this.getBorderPointRU().getX(),
                this.getBorderPointLD().getX(),this.getBorderPointRD().getX()};
        double[] thisBordery={this.getBorderPointLU().getY(),this.getBorderPointRU().getY(),
                this.getBorderPointLD().getY(),this.getBorderPointRD().getY()};

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

        if     ((this.getBorderPointLU().getX()<Xmin || this.getBorderPointLU().getX()>Xmax)||
                (this.getBorderPointLU().getY()<Ymin || this.getBorderPointLU().getY()>Ymax)||
                (this.getBorderPointRU().getX()<Xmin || this.getBorderPointRU().getX()>Xmax)||
                (this.getBorderPointRU().getY()<Ymin || this.getBorderPointRU().getY()>Ymax)||
                (this.getBorderPointLD().getX()<Xmin || this.getBorderPointLD().getX()>Xmax)||
                (this.getBorderPointLD().getY()<Ymin || this.getBorderPointLD().getY()>Ymax)||
                (this.getBorderPointRD().getX()<Xmin || this.getBorderPointRD().getX()>Xmax)||
                (this.getBorderPointRD().getY()<Ymin || this.getBorderPointRD().getY()>Ymax))
        {
            throw new IndexOutOfBoundsException("obiekt po za granicami farmy");
        } else {
            return true;
        }
    }


}

