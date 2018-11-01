package com.thetimickrus.menu;

import com.thetimickrus.State;

import javax.swing.*;
import java.awt.*;

public class SwitchColor extends Command {
    public SwitchColor(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Color c = JColorChooser.showDialog(null, "Выберите цвет", Color.black);
        state.setColor(c);
    }
}
