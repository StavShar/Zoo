package graphics;

import animals.*;
import plants.Cabbage;
import plants.Lettuce;
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
    private int listSize;
    private Plant plantFood;
    private final String BackgroundPath = IDrawable.PICTURE_PATH + "savanna.png";
    private BufferedImage image = null;
    private boolean BackgroundImage;


    private class ZooPanelButtons extends JPanel implements ActionListener{
        private ZooPanelButtons(){
            JButton btAddAnimal = new JButton("Add Animal");
            btAddAnimal.addActionListener(this);
            JButton btMoveAnimal = new JButton("Move Animal");
            btMoveAnimal.addActionListener(this);
            JButton btClear = new JButton("Clear");
            btClear.addActionListener(this);
            JButton btFood = new JButton("Food");
            btFood.addActionListener(this);
            JButton btInfo = new JButton("Info");
            btInfo.addActionListener(this);
            JButton btExit = new JButton("Exit");
            btExit.addActionListener(this);
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
                    Dialog d = new AddAnimalDialog();
                    Animal a = ((AddAnimalDialog) d).showDialog();
                    if(a != null)
                        addAnimal(a);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!\nyou can't add more than 10 animals");
            }
            else if(e.getActionCommand().equals("Move Animal")){
                if(listSize > 0) {
                    new MoveAnimalDialog(animalList);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no animals");
            }
            else if(e.getActionCommand().equals("Clear")){
                animalList = new ArrayList<>();
                listSize = 0;
                plantFood = null;
                JOptionPane.showMessageDialog(null, "All animals has been deleted");
                System.out.println("All animals has been deleted");
            }
            else if(e.getActionCommand().equals("Food")){
                Dialog fd = new FoodDialog();
                String temp = ((FoodDialog) fd).showDialog();
                switch (temp){
                    case "Lettuce": plantFood = new Lettuce();break;
                    case "Cabbage": plantFood = new Cabbage();break;
                    case "Meat": break;

                }

            }
            else if(e.getActionCommand().equals("Info")){
                new InfoDialog(getData());
            }
            else if(e.getActionCommand().equals("Exit"))
                exit(1);
            manageZoo();
        }
    }

    public ZooPanel(){
        plantFood = null;
        listSize = 0;
        animalList = new ArrayList<>();
        BackgroundImage = false;
        this.setLayout(new BorderLayout());
        try { image = ImageIO.read(new File(BackgroundPath));}
        catch (IOException e) { System.out.println("Cannot load image"); }
        this.add(new ZooPanelButtons(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public Object[][] getData(){
        Object data[][] = new String[listSize+1][InfoDialog.getColumnNumber()];
        int totalEatCounter = 0;
        for(int i=0; i<listSize; i++) {
            data[i][0] = animalList.get(i).getAnimalName();
            data[i][1] = animalList.get(i).getColor();
            double w = animalList.get(i).getWeight();
            w = (int)(w*100)/100.0;
            data[i][2] = String.valueOf(w);
            data[i][3] = String.valueOf(animalList.get(i).gethorSpeed());
            data[i][4] = String.valueOf(animalList.get(i).getVerSpeed());
            data[i][5] = String.valueOf(animalList.get(i).getEatCount());
            totalEatCounter += animalList.get(i).getEatCount();
        }
        data[listSize][0] = "Total";
        data[listSize][5] = String.valueOf(totalEatCounter);
        return data;
    }

    public void addAnimal(Animal a){
        if(a != null) {
            animalList.add(a);
            listSize++;
            System.out.println(animalList.get(listSize - 1).getName() + " has been added");
        }
    }

    public boolean isChange(){
        boolean flag = listSize == 0;
        for(int i=0; i<listSize; i++)
            if(animalList.get(i).getChanges()){
                animalList.get(i).setChanges(false);
                flag = true;
            }
        return flag;
    }

    public void manageZoo() {
        //while (true) {
            if (isChange())
                repaint();

            // need to check if some animal can eat another animal according to their locations
        //}
    }

    public void setBackgroundImage(boolean b) {
        this.BackgroundImage = b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (BackgroundImage)
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        for(int i=0; i<listSize; i++)
            animalList.get(i).drawObject(g);
        if(plantFood != null) {
            plantFood.setPan(this);
            plantFood.drawObject(g);
        }
    }
}
