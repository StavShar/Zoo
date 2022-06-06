package observer;

import graphics.ZooPanel;

import java.util.Observable;
import java.util.Observer;

/**
 * controller class represents the main thread, like a manager of ther zoo
 *
 * @version 2.0 6 June 2022
 * @author Stav Sharabi
 * */
public class Controller extends Thread implements Observer {
    private boolean run;

    public Controller(){
        run = true;
    }

    @Override
    public void run() {
        while(run){
            synchronized(this)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
           ZooPanel.getInstance().manageZoo();
        }
    }

    /**
     * update method so the observables can notify this thread
     * @param o
     * @param arg
     */
    public synchronized void update(Observable o, Object arg){
        notify();
    }


    public synchronized void ping(){
        notify();
    }
}
