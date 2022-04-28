package graphics;

import animals.Animal;
import mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoveAnimalDialog extends JDialog implements ActionListener {
    private final JComboBox<String> comboAnimals;
    private final ArrayList<Animal> list = ZooPanel.getAnimalList();
    private final int listSize = ZooPanel.getListSize();
    private JTextField jtX, jtY;
    public MoveAnimalDialog(){
        setModal(true);
        this.setTitle("Creating new animal");
        this.setLayout(new GridLayout(4, 2));
        this.add(new JLabel("    Animal: "));
        this.add(comboAnimals = new JComboBox<>());
        for(int i=0; i<listSize; i++)
            comboAnimals.addItem(list.get(i).getName());
        this.add(new JLabel("    X: "));
        jtX = new JTextField();
        this.add(jtX);
        this.add(new JLabel("    Y: "));
        jtY = new JTextField();
        this.add(jtY);
        this.add(new JLabel(""));
        JButton bt = new JButton("Move animal");
        bt.addActionListener(this);
        this.add(bt);
        this.setSize(250,120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Move animal"))
        {
            int x, y;
            try {
                x = Integer.parseInt(jtX.getText());
                y = Integer.parseInt(jtY.getText());
                if (mobility.Point.checkBounderies(new Point(x, y))) {
                    ZooPanel.moveAnimal(list.get(comboAnimals.getSelectedIndex()), new Point(x, y));
                    list.get(comboAnimals.getSelectedIndex()).setChanges(true);
                    dispose();
                }
                else {
                    if(x >= Point.getXMin() && x <= Point.getXMax())
                        JOptionPane.showMessageDialog(null, "Error!\nY must be between " + String.valueOf(Point.getYMin()) + "-" + String.valueOf(Point.getYMax()));
                    else
                        JOptionPane.showMessageDialog(null, "Error!\nX must be between " + String.valueOf(Point.getXMin()) + "-" + String.valueOf(Point.getXMax()));
                }
            } catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Error!\nX and Y must be an integers");
            }

        }
    }
}
