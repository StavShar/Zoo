package graphics;

    import animals.Animal;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;

/**
 * Dialog to duplicate an animal
 *
 * @version 2.0 4 June 2022
 * @author Stav Sharabi
 * */
public class DuplicateAnimalDialog  extends JDialog implements ActionListener {
    private final JComboBox<String> comboAnimals;
    private final ArrayList<Animal> list;

    /**
     * dialog constructor
     */
    public DuplicateAnimalDialog(ArrayList<Animal> animalList){
        this.setTitle("Duplicate animal");
        setModal(true);
        list = animalList;
        this.setLayout(new GridLayout(2, 2));
        this.add(new JLabel(" Animal: "));
        this.add(comboAnimals = new JComboBox<>());
        for(int i=0; i<list.size(); i++)
            comboAnimals.addItem(list.get(i).getName());
        this.add(new JLabel(""));
        JButton bt = new JButton("Duplicate");
        bt.addActionListener(this);
        this.add(bt);
        this.setSize(250,80);
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
        if(e.getActionCommand().equals("Duplicate")){
            Animal animal = list.get(comboAnimals.getSelectedIndex());
            Animal a =(Animal) animal.clone();
            a.setName(a.getClass().getSimpleName() + AddAnimalDialog.getAnimalCounter());
            a.setLocation(a.getStartingPoint());
            a.setWeight(a.getStartingWeight());
            a.setX_dir(1);
            a.setY_dir(1);
            list.add(a);
            dispose();
        }
    }
}
