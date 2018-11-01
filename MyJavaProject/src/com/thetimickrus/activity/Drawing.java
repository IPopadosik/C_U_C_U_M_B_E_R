package com.thetimickrus.activity;

import com.thetimickrus.model.MyModel;

import java.awt.geom.Point2D;

public class Drawing implements ActivityBehavior {
    MyModel myModel;
    Point2D[] p;

    public Drawing() {
        this.p = new Point2D[2];
    }

    public Drawing(MyModel myModel) {
        this.myModel = myModel;
        this.p = new Point2D[2];
    }

    @Override
    public void press(Point2D pointers) {
        p[0] = pointers;
        myModel.addShape();
    }

    @Override
    public void drag(Point2D pointers) {
        p[1] = pointers;
        myModel.setFromDiagonal(p);
    }

    @Override
    public void setModel(MyModel model) {
        this.myModel = model;
    }
}
