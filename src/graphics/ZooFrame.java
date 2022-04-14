package graphics;

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
    private final JLabel background = new JLabel(new ImageIcon("C:\\Users\\stav\\IdeaProjects\\temp\\src\\tempp\\savanna.jpg"));

    private final ZooPanel panel;

    /**
     * representing the top menu bar of the frame
     *
     * @version 1.0 14 apr 2022
     * @author Stav Sharabi
     * */
    private class menuBar extends JMenuBar {

        /**
         * menu bar constructor, creating the menu bar and his functionality
         */
        private menuBar() {
            JMenu fileMenu = new JMenu("File");
            JMenuItem exit = new JMenuItem("Exit");
            fileMenu.add(exit);
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exit(1);
                }
            });

            JMenu backgroundMenu = new JMenu("Background");
            JMenuItem image = new JMenuItem("Image");
            backgroundMenu.add(image);
            image.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackgroundImage(true);
                    panel.repaint();
                }
            });
            JMenuItem green = new JMenuItem("Green");
            backgroundMenu.add(green);
            green.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(Color.GREEN);
                    panel.setBackgroundImage(false);
                    panel.repaint();
                }
            });
            JMenuItem none = new JMenuItem("None");
            backgroundMenu.add(none);
            none.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(new Color(0,0,0, 0));
                    panel.setBackgroundImage(false);
                    panel.repaint();

                }
            });

            JMenu helpMenu = new JMenu("Help");
            JMenuItem help = new JMenuItem("Help");
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");
                }
            });
            helpMenu.add(help);
            this.add(fileMenu);
            this.add(backgroundMenu);
            this.add(helpMenu);
        }
    }

    /**
     * zoo's main frame constructor, creating the main frame of the zoo and adding the menubar and the zoo panel
     */
    public ZooFrame() {
        super("Zoo");
        panel = new ZooPanel();
        ZooFrame frame = this;
        setJMenuBar(new menuBar());
        this.add(panel);
        this.setLocation(350,200);
        this.setSize(1920, 774);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        ZooFrame window = new ZooFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
