package graphics;

import animals.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

/**
 * representing the zoo main frame
 *
 * @version 1.0 14 apr 2022
 * @author Stav Sharabi
 * */
public class ZooFrame extends JFrame {
    private final ZooPanel panel;

    /**
     * representing the top menu bar of the frame
     *
     * @version 1.0 14 apr 2022
     * @author Stav Sharabi
     * */
    private class menuBar extends JMenuBar implements ActionListener{

        /**
         * menu bar constructor, creating the menu bar and his functionality
         */
        private menuBar() {
            JMenu fileMenu = new JMenu("File");
            JMenuItem exit = new JMenuItem("Exit");
            fileMenu.add(exit);
            exit.addActionListener(this);
            JMenu backgroundMenu = new JMenu("Background");
            JMenuItem image = new JMenuItem("Image");
            backgroundMenu.add(image);
            image.addActionListener(this);
            JMenuItem green = new JMenuItem("Green");
            backgroundMenu.add(green);
            green.addActionListener(this);
            JMenuItem none = new JMenuItem("None");
            backgroundMenu.add(none);
            none.addActionListener(this);
            JMenu helpMenu = new JMenu("Help");
            JMenuItem help = new JMenuItem("Help");
            help.addActionListener(this);
            helpMenu.add(help);
            this.add(fileMenu);
            this.add(backgroundMenu);
            this.add(helpMenu);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Exit"))
                exit(1);
            if((e.getActionCommand().equals("Image")) || (e.getActionCommand().equals("Green")) || (e.getActionCommand().equals("None"))) {
                if (e.getActionCommand().equals("Image")) {
                    panel.setBackgroundImage(true);
                }
                else if (e.getActionCommand().equals("Green")) {
                    panel.setBackground(Color.GREEN);
                }
                else if (e.getActionCommand().equals("None")) {
                    panel.setBackground(new Color(0, 0, 0, 0));
                }
                if (!e.getActionCommand().equals("Image"))
                    panel.setBackgroundImage(false);
                panel.repaint();
            }
            if(e.getActionCommand().equals("Help")){
                JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");
            }
        }
    }

    /**
     * zoo's main frame constructor, creating the main frame of the zoo and adding the menubar and the zoo panel
     */
    public ZooFrame() {
        super("Zoo");
        this.setLocation(350,200);
        this.setSize(1000, 800);
        panel = new ZooPanel();
        ZooFrame frame = this;
        setJMenuBar(new menuBar());
        this.add(panel);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        ZooFrame window = new ZooFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
