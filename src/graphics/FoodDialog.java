package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FoodDialog extends JDialog {

    private class ButtonsPanel extends JPanel{
        private ButtonsPanel(){
            setLayout(new FlowLayout());
            JButton btLettuce = new JButton("Lettuce");
            JButton btCabbage = new JButton("Cabbage");
            JButton btMeat = new JButton("Meat");
            add(btLettuce);
            add(btCabbage);
            add(btMeat);
            setVisible(true);
        }
    }

    public FoodDialog(){
        JFrame frame = new JFrame("Food for animals");
        frame.setLayout(new BorderLayout());
        JLabel msg = new JLabel("Please choose food", SwingConstants.CENTER);
        msg.setFont(new Font("Arial",Font.TYPE1_FONT, 16));
        frame.add(msg);
        frame.add(new ButtonsPanel(), BorderLayout.SOUTH);
        frame.setSize(300,150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
