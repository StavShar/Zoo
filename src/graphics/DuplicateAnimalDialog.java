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
    private Animal animal;

    /**
     * dialog constructor
     */
    public DuplicateAnimalDialog(ArrayList<Animal> animalList){
        this.setTitle("Duplicate animal");
        setModal(true);
        list = animalList;
        animal = null;
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * showing dialog and return the duplicated animal
     * @return duplicated animal
     */
    public Animal showDialog(){
        this.setVisible(true);
        return animal;
    }


    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Duplicate")){
            animal = list.get(comboAnimals.getSelectedIndex());
            animal = (Animal) animal.clone();
            animal.setName(animal.getClass().getSimpleName() + AddAnimalDialog.getAnimalCounter());
            animal.setLocation(animal.getStartingPoint());
            animal.setWeight(animal.getStartingWeight());
            animal.setX_dir(1);
            animal.setY_dir(1);
            dispose();
        }
    }
}
