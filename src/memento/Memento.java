package memento;

import animals.Animal;
import food.IEdible;
import graphics.ZooPanel;
import java.util.ArrayList;
import java.util.Stack;

/**
 * class for saving and restoring states
 *
 * @version 2.0 5 June 2022
 * @author Stav Sharabi
 * */
public class Memento {
    private static Memento instance = null;
    private Stack<MementoState> stackMemento;
    private final int MAX_SAVES = 3;

    /**
     * inner class, representing the state we are looking to save/restore
     *
     * @version 3.0 6 June 2022
     * @author Stav Sharabi
     * */
    private class MementoState{
        private ArrayList<Animal> animalList;
        private int totalEatCounter;
        private IEdible food;
        private boolean bg;

        /**
         * state constructor
         * @param animalList - list of animals
         * @param totalEatCounter - counter of total eating
         * @param food - food on screen
         * @param bg - boolean if background image is set
         */
        public MementoState(ArrayList<Animal> animalList, int totalEatCounter, IEdible food, boolean bg){
            if (stackMemento.size() < MAX_SAVES) {
                this.totalEatCounter = totalEatCounter;
                this.food = food;
                this.bg = bg;
                this.animalList = new ArrayList<>();
                boolean flag = true;
                Animal a;
                for(Animal animal : animalList) {
                    flag = animal.isSuspended();
                    animal.setSuspended();
                    a = (Animal) animal.clone();
                    this.animalList.add(a);
                    if(!flag)
                        animal.setResumed();
                }
            }
        }
    }

    /**
     * memento constructor
     */
    private Memento(){
        stackMemento = new Stack<>();
    }

    /**
     * singleton DP, returning an instance of memento
     *
     * @return memento instance
     */
    public static Memento getInstance() {
        if(instance == null)
            instance = new Memento();
        return instance;
    }

    /**
     * saving state so you can restore later
     * @param animalList - list of animals
     * @param totalEatCounter - counter of total eating
     * @param food - food on screen
     * @param bg - boolean if background image is set
     * @return true if saving succeed
     */
    public boolean save(ArrayList<Animal> animalList, int totalEatCounter, IEdible food, boolean bg){
        if(stackMemento.size() < MAX_SAVES) {
            MementoState ms = new MementoState(animalList, totalEatCounter, food, bg);
            stackMemento.push(ms);
            return true;
        }
        return false;
    }

    /**
     * restoring state(you must save state before)
     * @return true if succeed
     */
    public boolean restore(){
        if(!stackMemento.empty()){
            MementoState ms = stackMemento.pop();
            ZooPanel.getInstance().loadState(ms.animalList, ms.totalEatCounter, ms.food, ms.bg);
            return true;
        }
        return false;
    }
}
