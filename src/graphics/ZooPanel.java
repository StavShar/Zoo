package graphics;

import animals.*;
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

import static animals.Animal.*;
import static animals.Animal.validHorSpeed;
import static java.lang.System.exit;

public class ZooPanel extends JPanel {
    private static ArrayList<Animal> animalList = new ArrayList<>();
    private static int listSize = 0;
    private Plant plantFood;
    private final String BackgroundPath = "C:\\Git Project\\Zoo\\src\\graphics\\pictures\\savanna.png";
    private BufferedImage image = null;
    private boolean BackgroundImage;




    private class ZooPanelButtons extends JPanel implements ActionListener{
        private ZooPanelButtons(){
            JButton btAddAnimal = new JButton("Add Animal");
            btAddAnimal.addActionListener(this);
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


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Add Animal")){
                if(listSize<10) {
                    AddAnimalDialog addAnimal = new AddAnimalDialog();
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!\nyou can't add more than 10 animals");
            }
        }
    }

    public ZooPanel(){
        plantFood = null;
        BackgroundImage = false;
        this.setLayout(new BorderLayout());
        try { image = ImageIO.read(new File(BackgroundPath));}
        catch (IOException e) { System.out.println("Cannot load image"); }
        this.add(new ZooPanelButtons(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void addAnimal(Animal a){
        if(a != null) {
            animalList.add(a);
            listSize++;
            System.out.println(animalList.get(listSize - 1).getName() + " has been added");
        }
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
