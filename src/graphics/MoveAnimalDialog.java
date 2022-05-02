package graphics;

import animals.Animal;
import mobility.Point;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Dialog to move animal
 *
 * @version 1.0 1 May 2022
 * @author Stav Sharabi
 * */
public class MoveAnimalDialog extends JDialog implements ActionListener {
    private final JComboBox<String> comboAnimals;
    private final ArrayList<Animal> list;
    private JTextField jtX, jtY;

    /**
     * Move animal dialog constructor
     * @param animalList list of the animals
     */
    public MoveAnimalDialog(ArrayList<Animal> animalList){
        setModal(true);
        this.setTitle("Creating new animal");
        this.setLayout(new GridLayout(4, 2));
        this.add(new JLabel("    Animal: "));
        list = animalList;
        this.add(comboAnimals = new JComboBox<>());
        for(int i=0; i<list.size(); i++)
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

    /**
     * moving animal method
     * @param a the animal you trying to move
     * @param p the new location of the animal
     */
    public void moveAnimal(Animal a, mobility.Point p){
        boolean flag = zoo.ZooActions.move(a, p);
        if(flag) {
            a.setChanges(true);
            System.out.println("Move successfully");
        }
        else
            System.out.println("Move ignored");
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Move animal"))
        {
            int x, y;
            try {
                x = Integer.parseInt(jtX.getText());
                y = Integer.parseInt(jtY.getText());
                if (mobility.Point.checkBounderies(new Point(x, y))) {
                    moveAnimal(list.get(comboAnimals.getSelectedIndex()), new Point(x, y));
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
