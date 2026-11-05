package Game;

import java.util.Random;

public class Die{

    private int numberOfSides;
    private int currentValue;
    private Random random;

    //Constructor
    Die(int numberOfSides){

        this.numberOfSides = numberOfSides;
        this.currentValue = 0;
        this.random = new Random();
    }

    public int getNumberOfSides(){
        return numberOfSides;
    }

    public int getCurrentValue(){
        return currentValue;
    }

    public void roll(){
        currentValue = random.nextInt(numberOfSides) + 1;
    }
}