package graphics;

/**
 * interface of animal behavior
 */
public interface IAnimalBehavior {

    /**
     * returning the type of the animal
     * @return animal type
     */
    public String getAnimalName();

    /**
     * returning the size of the animal
     * @return size
     */
    public int getSize();

    /**
     * increasing eatcount by 1
     */
    public void eatInc();

    /**
     * returning the eating counter of the animal
     * @return eatCount
     */
    public int getEatCount();


    /**
     * returning if there is any change by the location of the animal
     * @return true if there is a change
     */
    public boolean getChanges ();

    /**
     * update coordChanged if there is any change by the location of the animal
     * @param state true if there is a change
     */
    public void setChanges (boolean state);

    /**
     * the animal enter to waiting mode
     */
    public void setSuspended();

    /**
     * the animal is exit the waiting mode
     */
    public void setResumed();
}
