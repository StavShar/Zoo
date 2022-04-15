package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodDialog extends JDialog {


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
                System.out.println(e.getActionCommand());
            }
            if(e.getActionCommand().equals("Cabbage")){
                System.out.println(e.getActionCommand());
            }
            if(e.getActionCommand().equals("Meat")){
                System.out.println(e.getActionCommand());
            }
            dispose();
        }
    }

    public FoodDialog(){
        this.setTitle("Food for animals");
        this.setLayout(new BorderLayout());
        JLabel msg = new JLabel("Please choose food", SwingConstants.CENTER);
        msg.setFont(new Font("Arial",Font.TYPE1_FONT, 16));
        this.add(msg);
        this.add(new ButtonsPanel(), BorderLayout.SOUTH);
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
