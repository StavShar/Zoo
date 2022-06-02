package factories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class producing 3 types of animal's factories, by type
 *
 * @version 1.0 2 June 2022
 * @author Stav Sharabi
 * */
public class FactoryProducer extends JDialog {
    private AnimalFactory factory;

    /**
     * Panel of buttons to select factory type
     *
     * @version 1.0 2 June 2022
     * @author Stav Sharabi
     * */
    private class ButtonsPanel extends JPanel implements ActionListener {
        /**
         * Buttons panel constructor
         */
        private ButtonsPanel(){
            setLayout(new FlowLayout());
            JButton btCarnivore = new JButton("Carnivore");
            btCarnivore.addActionListener(this);
            JButton btOmnivore = new JButton("Omnivore");
            btOmnivore.addActionListener(this);
            JButton btHerbivore = new JButton("Herbivore");
            btHerbivore.addActionListener(this);
            add(btCarnivore);
            add(btOmnivore);
            add(btHerbivore);
            setVisible(true);
        }

        @Override
        /*
         * (non-Javadoc)
         *
         * @see java.awt.event.ActionListener
         */
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Carnivore")){
                factory = new CarnivoreFactory();
            }
            if(e.getActionCommand().equals("Omnivore")){
                factory = new OmnivoreFactory();
            }
            if(e.getActionCommand().equals("Herbivore")){
                factory = new HerbivoreFactory();
            }
            dispose();
        }
    }

    /**
     * dialog constructor
     */
    public FactoryProducer(){
        this.setTitle("Animal factories");
        setModal(true);
        this.setLayout(new BorderLayout());
        JLabel msg = new JLabel("Please select the right factory", SwingConstants.CENTER);
        msg.setFont(new Font("Arial",Font.TYPE1_FONT, 16));
        this.add(msg);
        this.add(new ButtonsPanel(), BorderLayout.SOUTH);
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * this method showing the dialog and returns the correct factory
     * @return animal factory
     */
    public AnimalFactory showDialog(){
        this.setVisible(true);
        return factory;
    }
}
