package com.thetimickrus.view;

import com.thetimickrus.State;
import com.thetimickrus.activity.Drawing;
import com.thetimickrus.activity.Moving;
import com.thetimickrus.menu.SwitchColor;
import com.thetimickrus.menu.SwitchShape;
import com.thetimickrus.menu.SwitchAction;
import com.thetimickrus.menu.SwitchState;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    MyPanel myPanel;
    State state;


    public MyFrame(MyPanel myPanel, State state) throws HeadlessException {
        this.state = state;
        this.myPanel = myPanel;
        add(myPanel);
        //////////////////////////////////////////////

        JMenuBar jMenuBar = new JMenuBar();
        this.setJMenuBar(jMenuBar);
        JToolBar jToolBar = new JToolBar();
        this.add(jToolBar, BorderLayout.NORTH);

        ArrayList<JMenu> menus = new ArrayList<>();
        menus.add(new JMenu("Фигуры"));
        menus.add(new JMenu("Действия"));
        menus.add(new JMenu("Fill\\NoFill"));
        menus.add(new JMenu("Цвет"));

        for(JMenu x: menus)
            jMenuBar.add(x);

        ArrayList<Action> list = new ArrayList<>();
        list.add(new SwitchState("Прямоугольник", new ImageIcon("0.png"),
                 new SwitchShape(new Rectangle2D.Double(), state)));

        list.add(new SwitchState("Овал", new ImageIcon("0.jpg"),
                 new SwitchShape(new Ellipse2D.Double(), state)));

        menus.get(0).add(list.get(0));
        menus.get(0).add(list.get(1));

        list.add(new SwitchState("Рисовать", new ImageIcon("0.gif"),
                 new SwitchAction(new Drawing(), state)));

        list.add(new SwitchState("Перемещать", new ImageIcon("1.gif"),
                 new SwitchAction(new Moving(), state)));

        menus.get(1).add(list.get(2));
        menus.get(1).add(list.get(3));

        list.add(new SwitchState("Выбрать цвет фигуры", new ImageIcon("000.gif"),
                 new SwitchColor(state)));

        menus.get(3).add(list.get(4));
/*
        for(Action x: list)
           jToolBar.add(x);
*/
        //////////////////////////////////////////////
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
