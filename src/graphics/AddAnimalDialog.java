package graphics;

import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static animals.Animal.*;

public class AddAnimalDialog extends JDialog implements ActionListener {
    private static int count = 1;
    private final String[] animals = {"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};
    private final String colors[] = {"Natural", "Blue", "Red"};
    private Animal animal;
    private JTextField jtSize, jtVerSpeed, jtHorSpeed;
    private final JComboBox<String> comboAnimals;
    private final JComboBox<String> comboColors;

    public Animal createAnimal(String col, String type, int size, int verSpeed, int horSpeed){
        Animal a = null;
        String name = type + Integer.toString(count);
        count++;
        boolean flag = false;
        for (int i = 0; i < animals.length; i++)
            if (animals[i].equals(type)) {
                flag = true;
                break;
            }
        if(!validColor(col))
            flag = false;
        if(!validSize(size))
            flag = false;
        if(!validVerSpeed(verSpeed))
            flag = false;
        if(!validHorSpeed(horSpeed))
            flag = false;
        if(flag){
            switch (type){
                case "Lion": a = new Lion(name, size, horSpeed, verSpeed, col); break;
                case "Bear": a = new Bear(name, size, horSpeed, verSpeed, col); break;
                case "Elephant": a = new Elephant(name, size, horSpeed, verSpeed, col); break;
                case "Giraffe": a = new Giraffe(name, size, horSpeed, verSpeed, col); break;
                case "Turtle": a = new Turtle(name, size, horSpeed, verSpeed, col); break;
            }
        }
        return a;//returning animal reference only if all the parameters are legal
    }

    public AddAnimalDialog(){
        this.setTitle("Creating new animal");
        setModal(true);
        animal = null;
        this.setLayout(new GridLayout(6, 2));
        this.add(new JLabel(" Animal: "));
        this.add(comboAnimals = new JComboBox<>());
        for(String animal: animals)
            comboAnimals.addItem(animal);
        this.add(new JLabel(" Color: "));
        this.add(comboColors = new JComboBox<>());
        for(String col: colors)
            comboColors.addItem(col);
        this.add(new JLabel(" Size: "));
        jtSize = new JTextField();
        this.add(jtSize);
        this.add(new JLabel(" Vertical speed: "));
        jtVerSpeed = new JTextField();
        this.add(jtVerSpeed);
        this.add(new JLabel(" Horizontal speed: "));
        jtHorSpeed = new JTextField();
        this.add(jtHorSpeed);
        this.add(new JLabel(""));
        JButton bt = new JButton("Add animal");
        bt.addActionListener(this);
        this.add(bt);
        this.setSize(250,150);
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
    }

    public Animal showDialog(){
        this.setVisible(true);
        return animal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add animal"))
        {
            String col = comboColors.getItemAt(comboColors.getSelectedIndex());
            String type = comboAnimals.getItemAt(comboAnimals.getSelectedIndex());
            int size, hs, vs;
            try {
                size = Integer.parseInt(jtSize.getText());
                hs = Integer.parseInt(jtHorSpeed.getText());
                vs = Integer.parseInt(jtVerSpeed.getText());
                if (Animal.validSize(size)) {
                    if (Animal.validVerSpeed(vs)) {
                        if (Animal.validHorSpeed(hs)) {
                            animal = createAnimal(col, type, size, hs, vs);
                            dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Error!\nhorizontal speed must be between 1-10");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error!\nvertical speed must be between 1-10");
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!\nsize must be between 50-300");

            } catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Error!\nsize and speeds must be an integers");
            }

        }
    }
}
