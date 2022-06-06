package graphics;

import animals.Animal;
import decoration.ColoredAnimal;
import decoration.ColoredAnimalDecor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Dialog to change color of an animal
 *
 * @version 2.0 3 June 2022
 * @author Stav Sharabi
 * */
public class ChangeColorDialog  extends JDialog implements ActionListener {
    private final String colors[] = {"Natural", "Blue", "Red"};
    private final JComboBox<String> comboAnimals;
    private final ArrayList<Animal> list;
    private final JComboBox<String> comboColors;

    /**
     * dialog constructor
     */
    public ChangeColorDialog(ArrayList<Animal> animalList){
        this.setTitle("Coloring an animal");
        setModal(true);
        list = animalList;
        this.setLayout(new GridLayout(3, 2));
        this.add(new JLabel(" Animal: "));
        this.add(comboAnimals = new JComboBox<>());
        for(int i=0; i<list.size(); i++)
            comboAnimals.addItem(list.get(i).getName());
        this.add(new JLabel(" Color: "));
        this.add(comboColors = new JComboBox<>());
        for(String col: colors)
            comboColors.addItem(col);
        this.add(new JLabel(""));
        JButton bt = new JButton("Change color");
        bt.addActionListener(this);
        this.add(bt);
        this.setSize(250,100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Change color")){
            String color = comboColors.getItemAt(comboColors.getSelectedIndex());
            Animal animal = list.get(comboAnimals.getSelectedIndex());
            if(animal.getColor().equalsIgnoreCase(color))
                JOptionPane.showMessageDialog(null, "Error!\nThis is already the color of this animal ");
            else{
                ColoredAnimal temp = new ColoredAnimalDecor(animal, color);
                temp.changeAnimalColor();
                dispose();
            }
        }
    }
}
