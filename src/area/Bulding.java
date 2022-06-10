package area;

import java.awt.geom.Point2D;

public abstract class Bulding {

    private int number;
    private Border border;
    private double price;

    public Border getBorder() {
        return this.border;
    }

    public Bulding(int number, Border border, double price) {
        this.number = number;
        this.border = border;
        this.price = price;
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




}





