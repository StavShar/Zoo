package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;


public class ZooFrame extends JFrame {
    private final JLabel background = new JLabel(new ImageIcon("C:\\Users\\stav\\IdeaProjects\\temp\\src\\tempp\\savanna.jpg"));
    private final ZooPanel panel;

    private class menuBar extends JMenuBar {
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
                    /**
                     *
                     */
                }
            });
            JMenuItem green = new JMenuItem("Green");
            backgroundMenu.add(green);
            green.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(Color.GREEN);
                }
            });
            JMenuItem none = new JMenuItem("None");
            backgroundMenu.add(none);
            none.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(new Color(0,0,0, 0));

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

    public ZooFrame(){
        super("Zoo");
        panel = new ZooPanel();
        ZooFrame frame = this;
        setJMenuBar(new menuBar());
        this.add(panel);
        this.setSize(500, 500);
        //this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ZooFrame window = new ZooFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
