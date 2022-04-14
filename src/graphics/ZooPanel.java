package graphics;

import animals.Animal;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.exit;

public class ZooPanel extends JPanel {
    private ArrayList<Animal> animalList;
    private Plant plantFood;

    private class ZooPanelButtons extends JPanel{
        private ZooPanelButtons(){
            JButton btAddAnimal = new JButton("Add Animal");
            btAddAnimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*
                    *   AddAnimalDialog to add animal
                    */
                }
            });
            JButton btMoveAnimal = new JButton("Move Animal");
            JButton btClear = new JButton("Clear");
            JButton btFood = new JButton("Food");
            JButton btInfo = new JButton("Info");
            JButton btExit = new JButton("Exit");
            btExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exit(1);
                }
            });
            this.setLayout(new FlowLayout());
            this.setBackground(new Color(16, 146, 229));
            this.add(btAddAnimal);
            this.add(btMoveAnimal);
            this.add(btClear);
            this.add(btFood);
            this.add(btInfo);
            this.add(btExit);
        }
    }
    public ZooPanel(){
        plantFood = null;
        animalList = null;
        this.setLayout(new BorderLayout());
        this.add(new ZooPanelButtons(), BorderLayout.SOUTH);
        setVisible(true);
    }

}
