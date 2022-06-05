package graphics;

    import animals.Animal;
    import decoration.ColoredAnimal;
    import decoration.ColoredAnimalDecor;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;

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
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Duplicate")){
            Animal animal = list.get(comboAnimals.getSelectedIndex());
            Animal a =(Animal) animal.clone();
            list.add(a);
            dispose();
        }
    }
}
