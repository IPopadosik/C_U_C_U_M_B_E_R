package com.thetimickrus.menu;

import com.thetimickrus.State;

public abstract class Command {
    State state;

    public Command(State state) {
        this.state = state;
    }

    abstract public void execute();
}
