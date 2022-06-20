package area;

import java.awt.geom.Point2D;

public interface centerable {
     public static Point2D findCenter(Border border) {

          Point2D BorderPointLU = border.getBorderPointLU();
          Point2D BorderPointRU = border.getBorderPointRU();
          Point2D BorderPointLD = border.getBorderPointLD();
          Point2D BorderPointRD = border.getBorderPointRD();

          double[] farmBorderx = {BorderPointLU.getX(), BorderPointRU.getX(), BorderPointLD.getX(), BorderPointRD.getX()};
          double[] farmBordery = {BorderPointLU.getY(), BorderPointRU.getY(), BorderPointLD.getY(), BorderPointRD.getY()};

          double Xmax = farmBorderx[0];
          for (int i = 1; i < 4; i++) {
               if (farmBorderx[i] > Xmax) {
                    Xmax = farmBorderx[i];
               }
          }

          double Xmin = farmBorderx[0];
          for (int i = 1; i < 4; i++) {
               if (farmBorderx[i] < Xmin) {
                    Xmin = farmBorderx[i];
               }
          }

          double Ymax = farmBordery[0];
          for (int i = 1; i < 4; i++) {
               if (farmBordery[i] > Ymax) {
                    Ymax = farmBorderx[i];
               }
          }

          double Ymin = farmBordery[0];
          for (int i = 1; i < 4; i++) {
               if (farmBordery[i] < Ymin) {
                    Ymin = farmBordery[i];
               }
          }
          System.out.println(Ymin);
          System.out.println(Ymax);
          System.out.println(Xmax);
          System.out.println(Xmin);

          double Xavg = avgt(Xmax, Xmin);
          double Yavg = avgt(Ymax, Ymin);
          Point2D center = new Point2D.Double(Xavg, Yavg);
          return center;
     }


     public static double avgt(double a, double b) {     //ta metoda zwraca srodek lini zawartej pomiedzy dwoma punktami
          double avg;
          if (a >= 0 && b >= 0) {
               avg = (a + b) / 2;
          } else if (a < 0 && b >= 0) {
               avg = ((Math.abs(a) + b) / 2) - Math.abs(a);
          } else if (a >= 0 && b < 0) {
               avg = ((a + Math.abs(b)) / 2) - Math.abs(b);
          } else {
               avg = ((Math.abs(a) + Math.abs(b)) / 2) * -1;
          }
          return avg;
     }
}
          


