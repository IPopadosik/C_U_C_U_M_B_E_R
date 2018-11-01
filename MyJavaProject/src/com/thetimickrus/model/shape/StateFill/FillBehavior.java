package com.thetimickrus.model.shape.StateFill;

import java.awt.*;
import java.awt.geom.RectangularShape;

public interface FillBehavior {
    void draw(Color color, RectangularShape rectangularShape, Graphics2D graphics2D);
    FillBehavior clone();
}
