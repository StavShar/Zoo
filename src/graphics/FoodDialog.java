package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodDialog extends JDialog {
private String food;

    private class ButtonsPanel extends JPanel implements ActionListener{
        private ButtonsPanel(){
            setLayout(new FlowLayout());
            JButton btLettuce = new JButton("Lettuce");
            btLettuce.addActionListener(this);
            JButton btCabbage = new JButton("Cabbage");
            btCabbage.addActionListener(this);
            JButton btMeat = new JButton("Meat");
            btMeat.addActionListener(this);
            add(btLettuce);
            add(btCabbage);
            add(btMeat);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Lettuce")){
                food = "Lettuce";
            }
            if(e.getActionCommand().equals("Cabbage")){
                food = "Cabbage";
            }
            if(e.getActionCommand().equals("Meat")){
                food = "Meat";
            }
            dispose();
        }
    }

    public FoodDialog(){
        this.setTitle("Food for animals");
        setModal(true);
        this.setLayout(new BorderLayout());
        JLabel msg = new JLabel("Please choose food", SwingConstants.CENTER);
        msg.setFont(new Font("Arial",Font.TYPE1_FONT, 16));
        this.add(msg);
        this.add(new ButtonsPanel(), BorderLayout.SOUTH);
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
    }

    public String showDialog(){
        this.setVisible(true);
        return food;
    }
}
