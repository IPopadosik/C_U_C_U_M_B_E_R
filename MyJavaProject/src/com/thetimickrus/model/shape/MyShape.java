package com.thetimickrus.model.shape;

import com.thetimickrus.model.shape.StateFill.FillBehavior;
import com.thetimickrus.model.shape.StateFill.NoFillShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.Observable;

public class MyShape extends Observable {
    RectangularShape rectangularShape;
    Color color;
    FillBehavior fillBehavior;

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
    }

    public RectangularShape getRectangularShape() {
        return rectangularShape;
    }

    public MyShape(RectangularShape rectangularShape, Color color) {
        this.rectangularShape = rectangularShape;
        this.color = color;
        fillBehavior = new NoFillShape();
    }

    public void setRectangularShape(RectangularShape rectangularShape) {
        this.rectangularShape = rectangularShape;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics2D graphics2D) {
        fillBehavior.draw(color, rectangularShape, graphics2D);
    }

    public void setFromDiagonal(Point2D[] p)
    {
        rectangularShape.setFrameFromDiagonal(p[0], p[1]);
        this.setChanged();
        this.notifyObservers();
    }
    public MyShape clone(){
        MyShape s = new MyShape((RectangularShape)rectangularShape.clone(),color);
        s.setFillBehavior(fillBehavior.clone());
        return s;
    }
}
