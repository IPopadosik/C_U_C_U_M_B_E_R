package com.thetimickrus.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchState extends AbstractAction {

    public SwitchState(String name, Icon icon, Command command) {
        super(name, icon);
        putValue("Command", command);

        this.putValue(Action.SHORT_DESCRIPTION, name + " (действие)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command c = (Command) getValue("Command");
        c.execute();
    }
}
