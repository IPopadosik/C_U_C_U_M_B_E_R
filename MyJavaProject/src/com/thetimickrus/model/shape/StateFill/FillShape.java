package com.thetimickrus.model.shape.StateFill;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class FillShape implements FillBehavior {

    @Override
    public void draw(Color color, RectangularShape rectangularShape, Graphics2D graphics2D) {
        Paint paint = graphics2D.getPaint();

        graphics2D.setPaint(color);
        graphics2D.draw(rectangularShape);
        graphics2D.setPaint(paint);
    }

    @Override
    public FillBehavior clone() {
       return new FillShape();
    }
}
