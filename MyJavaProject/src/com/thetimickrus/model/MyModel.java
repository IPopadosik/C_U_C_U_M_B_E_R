package com.thetimickrus.model;

import com.thetimickrus.model.shape.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MyModel extends Observable {
    List<MyShape> list;
    MyShape currentShape;

    private static MyModel ourInstance = new MyModel();

    public static MyModel getInstance() {
        return ourInstance;
    }

    private MyModel() {
        list = new ArrayList<>();
    }

    public void setCurrentShape(MyShape currentShape) {
        this.currentShape = currentShape;
    }

    public void draw(Graphics2D graphics2D) {
        if (!list.isEmpty())
            for (MyShape x: list)
                x.draw(graphics2D);
    }

    public void addShape() {
        currentShape = currentShape.clone();
        list.add(currentShape);
    }

    public void setFromDiagonal(Point2D[] p) {
        currentShape.setFromDiagonal(p);

        setChanged();
        notifyObservers();
    }

    public void fineShape(Point2D pointers) {
        if (!list.isEmpty())
        {
            MyShape h = null;
            for (MyShape x: list)
                if (x.getRectangularShape().contains(pointers))
                    h = x;

            currentShape = h;
        }
    }

    public void moveShape(Point2D[] p) {
        double deltaX = p[0].getX() - p[1].getX();

        double deltaY = p[0].getY() - p[1].getY();

        if (currentShape != null) {

            double xMin = currentShape.getRectangularShape().getMinX() - deltaX;

            double yMin = currentShape.getRectangularShape().getMinY() - deltaY;

            double xMax = currentShape.getRectangularShape().getMaxX() - deltaX;

            double yMax = currentShape.getRectangularShape().getMaxY() - deltaY;

            currentShape.getRectangularShape().setFrameFromDiagonal(xMin, yMin, xMax, yMax);

            p[0] = p[1];
            setChanged();
            notifyObservers();
        }
    }
}
