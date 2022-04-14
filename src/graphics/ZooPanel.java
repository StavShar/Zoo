package graphics;

import animals.Animal;
import plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

public class ZooPanel extends JPanel {
    private ArrayList<Animal> animalList;
    private Plant plantFood;
    private final String BackgroundPath = "C:\\Git Project\\Zoo\\src\\graphics\\pictures\\savanna.png";
    private BufferedImage image = null;
    private boolean BackgroundImage;


    private class ZooPanelButtons extends JPanel{
        private ZooPanelButtons(){
            JButton btAddAnimal = new JButton("Add Animal");
            btAddAnimal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*
                    *   AddAnimalDialog to add animal
                    */
                }
            });
            JButton btMoveAnimal = new JButton("Move Animal");
            JButton btClear = new JButton("Clear");
            JButton btFood = new JButton("Food");
            btFood.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog food = new FoodDialog();
                }
            });
            JButton btInfo = new JButton("Info");
            JButton btExit = new JButton("Exit");
            btExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exit(1);
                }
            });
            this.setLayout(new FlowLayout());
            this.setBackground(new Color(16, 146, 229));
            this.add(btAddAnimal);
            this.add(btMoveAnimal);
            this.add(btClear);
            this.add(btFood);
            this.add(btInfo);
            this.add(btExit);
        }
    }
    public ZooPanel(){
        plantFood = null;
        animalList = null;
        BackgroundImage = false;
        this.setLayout(new BorderLayout());
        try { image = ImageIO.read(new File(BackgroundPath));}
        catch (IOException e) { System.out.println("Cannot load image"); }
        this.add(new ZooPanelButtons(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public void setBackgroundImage(boolean b) {
        this.BackgroundImage = b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (BackgroundImage)
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
}
