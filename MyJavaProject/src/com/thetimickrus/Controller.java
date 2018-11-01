package com.thetimickrus;

import com.thetimickrus.activity.Drawing;
import com.thetimickrus.model.MyModel;
import com.thetimickrus.model.shape.MyShape;
import com.thetimickrus.view.MyFrame;
import com.thetimickrus.view.MyPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Controller {
    MyModel myModel;
    State state;
    MyPanel myPanel;
    MyFrame myFrame;

    public Controller() {
        myModel = MyModel.getInstance();

        state = new State(new MyShape(new Rectangle2D.Double(), Color.black), Color.black, myModel, new Drawing());
        state.setModel(myModel);

        myPanel = new MyPanel(this);
        myModel.addObserver(myPanel);

        myFrame = new MyFrame(myPanel, state);
    }

    public MyModel getModel() {
        return myModel;
    }

    public void draw(Graphics2D g) {
        myModel.draw(g);
    }

    public void press(Point point) {
        state.getActivity().press(point);
    }

    public void drag(Point point) {
        state.getActivity().drag(point);
    }
}
