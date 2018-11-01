package com.thetimickrus.menu;

import com.thetimickrus.State;
import com.thetimickrus.model.shape.StateFill.FillBehavior;

public class SwitchFill extends Command {
    FillBehavior fillBehavior;

    public SwitchFill(FillBehavior fillBehavior, State state) {
        super(state);
        this.fillBehavior = fillBehavior;
    }

    @Override
    public void execute() {

    }
}
