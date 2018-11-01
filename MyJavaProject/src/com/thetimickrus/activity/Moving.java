package com.thetimickrus.activity;

import com.thetimickrus.model.MyModel;
import java.awt.geom.Point2D;

public class Moving implements ActivityBehavior {
    MyModel myModel;
    Point2D[] p;

    public Moving() {
        p = new Point2D[2];
    }

    @Override
    public void press(Point2D pointers) {
        p[0] = pointers;
        myModel.fineShape(pointers);
    }

    @Override
    public void drag(Point2D pointers) {
        p[1] = pointers;
        myModel.moveShape(p);
    }

    @Override
    public void setModel(MyModel model) {
        myModel = model;
    }
}
