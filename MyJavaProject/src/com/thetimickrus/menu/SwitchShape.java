package com.thetimickrus.menu;

import com.thetimickrus.State;
import java.awt.geom.RectangularShape;

public class SwitchShape extends Command {
    RectangularShape shape;

    public SwitchShape(RectangularShape shape, State state) {
        super(state);
        this.shape = shape;
    }

    @Override
    public void execute() {
        state.setMyShape(shape);
    }
}
