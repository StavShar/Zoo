package graphics;

import animals.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog to get data about the new animal
 *
 * @version 2.0 2 June 2022
 * @author Stav Sharabi
 * */
public class AddAnimalDialog extends JDialog implements ActionListener {
    private static int count = 1;
    private String[] animals;
    private final String colors[] = {"Natural", "Blue", "Red"};
    private String[] data;
    private JTextField jtSize, jtVerSpeed, jtHorSpeed;
    private final JComboBox<String> comboAnimals;
    private final JComboBox<String> comboColors;

    /**
     * dialog constructor
     */
    public AddAnimalDialog(String[] animals){
        this.setTitle("Creating new animal");
        setModal(true);
        data = null;
        this.animals = animals;
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * showing this dialog and returning the inserted data of the animal
     * @return data of the animal
     */
    public String[] showDialog(){
        this.setVisible(true);
        return data;
    }

    /**
     * returning the counter to identify cloned animals
     * @return animal number
     */
    public static int getAnimalCounter(){
        return count++;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add animal"))
        {
            String col = comboColors.getItemAt(comboColors.getSelectedIndex());
            String type = comboAnimals.getItemAt(comboAnimals.getSelectedIndex());
            try {
                if (Animal.validSize(Integer.parseInt(jtSize.getText()))) {
                    if (Animal.validVerSpeed(Integer.parseInt(jtVerSpeed.getText()))) {
                        if (Animal.validHorSpeed(Integer.parseInt(jtHorSpeed.getText()))) {
                            String name = type + count;
                            count++;
                            data = new String[]{name, col, type, jtSize.getText(), jtHorSpeed.getText(), jtVerSpeed.getText()};
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
