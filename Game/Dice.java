package Game;

import java.util.Random;

public class Dice {

    private int currentValue;
    private  int numberOfSides;
    private Random random;

    Dice(int numberOfSides)
    {
        this.currentValue = 0;
        this.numberOfSides = numberOfSides;
        this.random = new Random();
    }

    public int getCurrentValue()
    {
        return currentValue;
    }
    

    public  int getNumberOfSides()
    {
        return  numberOfSides;
    }

    public void roll()
    {
        currentValue = random.nextInt(numberOfSides)+1;
    }
}
