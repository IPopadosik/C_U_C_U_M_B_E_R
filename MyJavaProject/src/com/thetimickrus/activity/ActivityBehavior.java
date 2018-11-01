package com.thetimickrus.activity;

import com.thetimickrus.model.MyModel;

import java.awt.geom.Point2D;

public interface ActivityBehavior {
    void press(Point2D pointers);
    void drag(Point2D pointers);
    void setModel(MyModel model);
}
