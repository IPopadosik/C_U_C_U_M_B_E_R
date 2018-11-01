package com.thetimickrus.menu;

import com.thetimickrus.State;
import com.thetimickrus.activity.ActivityBehavior;

public class SwitchAction extends Command {
    ActivityBehavior activityBehavior;

    public SwitchAction(ActivityBehavior activityBehavior, State state) {
        super(state);
        this.activityBehavior = activityBehavior;
    }

    @Override
    public void execute() {
        state.setActivity(activityBehavior);
    }
}
