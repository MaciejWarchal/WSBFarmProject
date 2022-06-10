package area;

import java.awt.geom.Point2D;

public interface centerable {
     Point2D findCenter(Point2D borderPointLU, Point2D borderPointRU, Point2D borderPointLD,
                               Point2D borderPointRD);
}
