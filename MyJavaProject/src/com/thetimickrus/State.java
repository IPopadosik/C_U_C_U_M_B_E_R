package com.thetimickrus;

import com.thetimickrus.activity.ActivityBehavior;
import com.thetimickrus.model.MyModel;
import com.thetimickrus.model.shape.MyShape;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class State {
    MyModel myModel;
    MyShape myShape;
    Color color;
    ActivityBehavior activityBehavior;

    public State(MyShape myShape, ActivityBehavior activity) {
        this.myShape = myShape;
        this.activityBehavior = activity;
    }

    public State(MyShape myShape, Color color, MyModel myModel, ActivityBehavior activity) {
        this.myShape = myShape;
        this.color = color;
        this.myModel = myModel;
        this.activityBehavior = activity;
        activityBehavior.setModel(myModel);
        myModel.setCurrentShape(myShape);
    }

    public MyShape getMyShape() {
        return myShape;
    }

    public void setMyShape(RectangularShape myShape) {
        this.myShape.setRectangularShape(myShape);
        this.myShape.setColor(color);
        myModel.setCurrentShape(this.myShape);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        myShape.setColor(color);
        myModel.setCurrentShape(myShape);
    }

    public ActivityBehavior getActivity() {
        return activityBehavior;
    }

    public void setActivity(ActivityBehavior activity) {
        this.activityBehavior = activity;
        this.activityBehavior.setModel(myModel);
        myModel.setCurrentShape(myShape);
    }

    public void setModel(MyModel model) {
        this.myModel = model;
        activityBehavior.setModel(model);
        model.setCurrentShape(myShape);
    }
}