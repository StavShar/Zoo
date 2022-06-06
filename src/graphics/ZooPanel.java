package graphics;

import animals.*;
import factories.AnimalFactory;
import factories.FactoryProducer;
import food.IEdible;
import food.Meat;
import memento.Memento;
import mobility.Point;
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
import static java.lang.Math.abs;
import static java.lang.System.exit;

/**
 * Main panel of the zoo, where animals will be drawn
 *
 * @version 3.0 18 May 2022
 * @author Stav Sharabi
 * */
public class ZooPanel extends JPanel implements Runnable{
    public static ZooPanel instance = null;
    private final int MAX_THREADS = 10;
    private final int MAX_POOL_SIZE = 5;
    private final Point midP;
    private ArrayList<Animal> animalList;
    private int totalEatCounter;
    private Plant plantFood;
    private Meat meatFood;
    private boolean foodChange;
    private final String BackgroundPath = IDrawable.PICTURE_PATH + "savanna.png";
    private BufferedImage image = null;
    private boolean BackgroundImage;
    private Thread controller;
    private boolean alive;
    /**
     * Buttons panel of the zoo panel
     *
     * @version 1.0 1 May 2022
     * @author Stav Sharabi
     * */
    private class ZooPanelButtons extends JPanel implements ActionListener {

        /**
         * Zoo buttons panel constructor
         */
        private ZooPanelButtons() {
            JButton btAddAnimal = new JButton("Add Animal");
            btAddAnimal.addActionListener(this);
            JButton btChangeColor = new JButton("Change Color");
            btChangeColor.addActionListener(this);
            JButton btDuplicate = new JButton("Duplicate");
            btDuplicate.addActionListener(this);
            JButton btSleep = new JButton("Sleep");
            btSleep.addActionListener(this);
            JButton btWakeUp = new JButton("Wake Up");
            btWakeUp.addActionListener(this);
            JButton btClear = new JButton("Clear");
            btClear.addActionListener(this);
            JButton btFood = new JButton("Food");
            btFood.addActionListener(this);
            JButton btInfo = new JButton("Info");
            btInfo.addActionListener(this);
            JButton btSaveState = new JButton("Save State");
            btSaveState.addActionListener(this);
            JButton btRestoreState = new JButton("Restore State");
            btRestoreState.addActionListener(this);
            JButton btExit = new JButton("Exit");
            btExit.addActionListener(this);
            this.setLayout(new FlowLayout());
            this.setBackground(new Color(16, 146, 229));
            this.add(btAddAnimal);
            this.add(btDuplicate);
            this.add(btChangeColor);
            this.add(btSleep);
            this.add(btWakeUp);
            this.add(btClear);
            this.add(btFood);
            this.add(btInfo);
            this.add(btSaveState);
            this.add(btRestoreState);
            this.add(btExit);
        }

        @Override
        /*
         * (non-Javadoc)
         *
         * @see java.awt.event.ActionListener
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Animal")) {
                if (animalList.size() < 10) {
                    FactoryProducer factoryProducer = new FactoryProducer();
                    AnimalFactory factory = factoryProducer.showDialog();
                    if(factory != null) {
                        Animal a = factory.produceAnimal();
                        if (a != null)
                            addAnimal(a);
                    }
                } else
                    JOptionPane.showMessageDialog(null, "Error!\nyou can't add more than 10 animals");
            }
            else if (e.getActionCommand().equals("Change Color")) {
                if (animalList.size() > 0) {
                    new ChangeColorDialog(animalList);
                } else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no animals");
            }
            else if (e.getActionCommand().equals("Duplicate")) {
                if (animalList.size() > 0) {
                    if (animalList.size() > 0)
                        new DuplicateAnimalDialog(animalList);
                } else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no animals");
            }
            else if (e.getActionCommand().equals("Sleep")) {
                if (animalList.size() > 0) {
                    for (Animal a : animalList)
                        a.setSuspended();
                } else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no animals");
            }
            else if (e.getActionCommand().equals("Wake Up")) {
                if (animalList.size() > 0) {
                    for (Animal a : animalList)
                        a.setResumed();
                } else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no animals");
            }
            else if (e.getActionCommand().equals("Clear")) {
                if (animalList.size() > 0) {
                    for (Animal a : animalList)
                        a.kill(); //kill the thread
                }
                animalList = new ArrayList<>();
                totalEatCounter = 0;
                plantFood = null;
                meatFood = null;
                setFoodChange(true);
                JOptionPane.showMessageDialog(null, "All animals and food has been deleted");
            }
            else if (e.getActionCommand().equals("Food")) {
                if((meatFood == null) && (plantFood == null)) {
                    Dialog fd = new FoodDialog();
                    String temp = ((FoodDialog) fd).showDialog();
                    if (temp != null) {
                        switch (temp) {
                            case "Lettuce":
                                plantFood = Lettuce.getInstance();
                                setFoodChange(true);
                                break;
                            case "Cabbage":
                                plantFood = Cabbage.getInstance();
                                setFoodChange(true);
                                break;
                            case "Meat":
                                meatFood = Meat.getInstance();
                                setFoodChange(true);
                                break;
                        }
                        if (getFoodChange())
                            System.out.println("Food has been added");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "You can't add more food until the food will be eaten");
            }
            else if (e.getActionCommand().equals("Info")) {
                new InfoDialog(getData());
            }
            else if (e.getActionCommand().equals("Save State")) {
                IEdible food = null;
                if(meatFood != null)
                    food = Meat.getInstance();
                else if(plantFood != null)
                    if(plantFood instanceof Cabbage)
                        food = Cabbage.getInstance();
                    else
                        food = Lettuce.getInstance();

                if(Memento.getInstance().save(animalList, totalEatCounter, food))
                    JOptionPane.showMessageDialog(null, "State has been saved successfully");
                else
                    JOptionPane.showMessageDialog(null, "Error!\nMax saves has been reached");
            }
            else if (e.getActionCommand().equals("Restore State")) {
                if(Memento.getInstance().restore()){
                    repaint();
                    JOptionPane.showMessageDialog(null, "State has been load successfully");
                }
                else
                    JOptionPane.showMessageDialog(null, "Error!\nthere are no any saved state");
            }
            else if (e.getActionCommand().equals("Exit")) {
                ZooPanel.getInstance().stopAllThreads();
                exit(0);
            }
        }
    }

    /**
     * loading state when state is being restored
     * @param animalList - list of animals
     * @param totalEatCounter - counter for total eating
     * @param food - food on screen
     */
    public void loadState(ArrayList<Animal> animalList, int totalEatCounter, IEdible food){
        this.animalList = new ArrayList<>();
        for(Animal animal : animalList) {
            this.animalList.add((Animal) animal.clone());
        }
        this.totalEatCounter = totalEatCounter;
        meatFood = null;
        plantFood = null;
        if(food instanceof Meat)
            meatFood = (Meat) food;
        else if(food instanceof Plant)
            plantFood = (Plant) food;
        repaint();
    }

    /**
     * adding 1 to total eat counter
     */
    public void totalEatCounterInc(){totalEatCounter++;}

    /**
     * return total eat counter
     * @return totalEatCounter
     */
    public int getTotalEatCounter(){return totalEatCounter;}

    /**
     * ensuring that Zoopanel is a singletone
     * @return the instance of the Zoopanel
     */
    public static ZooPanel getInstance() {
        if(instance == null)
            instance = new ZooPanel();
        return instance;
    }

    /**
     * zoo's main panel constructor
     */
    private ZooPanel() {
        plantFood = null;
        totalEatCounter = 0;
        animalList = new ArrayList<>();
        foodChange = false;
        alive = true;
        controller = new Thread(this);
        BackgroundImage = false;
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        try {
            image = ImageIO.read(new File(BackgroundPath));
        } catch (IOException e) {
            System.out.println("Cannot load image");
        }
        this.add(new ZooPanelButtons(), BorderLayout.SOUTH);
        midP = new Point(this.getWidth()/2 ,this.getHeight()/2);
        controller.start();
        setVisible(true);
    }

    @Override
    public void run() {
        while (alive){
            manageZoo();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * return the middle point of the panel (the point where food will be placed)
     * @return midP
     */
    public Point getMidP() {
        return midP;
    }

    /**
     * this thread will end his job
     */
    public void kill(){
        alive = false;
    }

    /**
     * stopping all the threads in the panel
     */
    public void stopAllThreads(){
        for (Animal a : animalList)
            a.kill(); //kill the thread
        this.kill();
    }
    /**
     * get all the data of the animals organized in a matrix
     * @return all data organized in matrix
     */
    public Object[][] getData() {
        Object data[][] = new String[animalList.size() + 1][InfoDialog.getColumnNumber()];
        int totalEatCounter = 0;
        for (int i = 0; i < animalList.size(); i++) {
            data[i][0] = animalList.get(i).getName();
            data[i][1] = animalList.get(i).getColor();
            double w = animalList.get(i).getWeight();
            w = (int) (w * 100) / 100.0;
            data[i][2] = String.valueOf(w);
            data[i][3] = String.valueOf(animalList.get(i).gethorSpeed());
            data[i][4] = String.valueOf(animalList.get(i).getVerSpeed());
            data[i][5] = String.valueOf(animalList.get(i).getEatCount());
        }
        data[animalList.size()][0] = "Total";
        data[animalList.size()][5] = String.valueOf(getTotalEatCounter());
        return data;
    }

    /**
     * Adding animal to the animal list
     * @param a animal
     */
    public void addAnimal(Animal a) {
        if (a != null) {
            animalList.add(a);
            System.out.println(animalList.get(animalList.size() - 1).getName() + " has been added");
        }
    }

    /**
     * Set true if food has been added/eaten
     * @param b true/false
     */
    public void setFoodChange(boolean b){
        foodChange = b;
    }

    /**
     * Check if food has been added/eaten
     * @return
     */
    public boolean getFoodChange(){
        return foodChange;
    }

    /**
     * Checking if there was any change on the main panel
     * @return true/false
     */
    public boolean isChange() {
        boolean flag = false;
        for (int i = 0; i < animalList.size(); i++)
            if (animalList.get(i).getChanges()) {
                animalList.get(i).setChanges(false);
                flag = true;
            }
        if(getFoodChange()){
            setFoodChange(false);
            flag = true;
        }
        return flag;
    }

    /**
     *  Looking  for changes, if there is any change it will repaint the updated panel
     */
    public void manageZoo() {
        if(meatFood != null){
            for(Animal a:animalList)
                if(a.getDiet().canEat(meatFood.getFoodtype())) {
                    if (a.getLocation().getX() < midP.getX())
                        a.setX_dir(1);
                    else if(a.getLocation().getX() > midP.getX())
                        a.setX_dir(-1);
                    if (a.getLocation().getY() < midP.getY())
                        a.setY_dir(1);
                    else if(a.getLocation().getY() > midP.getY())
                        a.setY_dir(-1);
                }
        }
        else if(plantFood != null){
            for(Animal a:animalList)
                if(a.getDiet().canEat(plantFood.getFoodtype())) {
                    if (a.getLocation().getX() < midP.getX())
                        a.setX_dir(1);
                    else if(a.getLocation().getX() > midP.getX())
                        a.setX_dir(-1);
                    if (a.getLocation().getY() < midP.getY())
                        a.setY_dir(1);
                    else if(a.getLocation().getY() > midP.getY())
                        a.setY_dir(-1);
                }
        }

        // checking if animal moved or food has been added
        if (isChange())
            repaint();

        //checking if animal eats the food
        if(plantFood != null){
            for (int i = 0; i < animalList.size(); i++) {
                // if distance on X axis < 10  and  distance on Y axis < 10
                if( abs(animalList.get(i).getLocation().getX() - plantFood.getLocation().getX())<10 && abs(animalList.get(i).getLocation().getY() - plantFood.getLocation().getY()) < 10){
                    //eat food
                    if(animalList.get(i).eat(plantFood)){
                        animalList.get(i).eatInc();
                        totalEatCounterInc();
                        plantFood = null;
                        repaint();
                        System.out.println("Food has been eaten by " + animalList.get(i));
                        break;
                    }

                }
            }
        }
        //checking if animal eats the food
        else if(meatFood != null){
            for (int i = 0; i < animalList.size(); i++) {
                // if distance on X axis < 10  and  distance on Y axis < 10
                if( abs(animalList.get(i).getLocation().getX() - meatFood.getLocation().getX()) < animalList.get(i).getEAT_DISTANCE() && abs(animalList.get(i).getLocation().getY() - meatFood.getLocation().getY()) < animalList.get(i).getEAT_DISTANCE()){
                    //eat food
                    if(animalList.get(i).eat(meatFood)){
                        animalList.get(i).eatInc();
                        totalEatCounterInc();
                        meatFood = null;
                        repaint();
                        System.out.println("Food has been eaten by " + animalList.get(i));
                        break;
                    }

                }
            }
        }
        // checking if animal eats an animal
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < animalList.size(); i++)
                for (int j = 0; j < animalList.size(); j++)
                    if(animalList.get(i).getDiet().canEat(animalList.get(j).getFoodtype()))
                        if (animalList.get(i).getWeight() >= 2 * animalList.get(j).getWeight())
                            if (animalList.get(i).calcDistance(animalList.get(j).getLocation()) < animalList.get(j).getSize())
                                if (animalList.get(i).eat(animalList.get(j))) {
                                    animalList.get(i).eatInc();
                                    totalEatCounterInc();
                                    System.out.println(animalList.get(i) + " ate " + animalList.get(j));
                                    animalList.get(j).kill();
                                    animalList.remove(j);
                                    flag = true;
                                    break;
                                }
        } while(flag);
    }

    /**
     * set background
     * @param b  true/false
     */
    public void setBackgroundImage(boolean b) {
        this.BackgroundImage = b;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see   javax.swing.JComponent
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (BackgroundImage)
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        for (int i = 0; i < animalList.size(); i++)
            animalList.get(i).drawObject(g);
        if (plantFood != null) {
            plantFood.drawObject(g);
        }
        else if (meatFood != null) {
            meatFood.drawObject(g);
        }
    }
}
