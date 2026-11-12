package Game;

public class Player {

    private String playerName;
    private int score = 0;
    private Dice die;

    Player(String playerName)
    {
        this.playerName = playerName;
        
    }
    

    public String getPlayerName()
    {
        return playerName;
    }

    public  void setScore(int score)
    {
        this.score = score;
       
    }

    public  int getScore()
    {
        return  score;
    }

    public void rollDice()
    {
        die.roll();
    }

    public int getDieValue()
    {
        int dieValue = die.getCurrentValue();
        return dieValue;

    }

    public void increaseScore()
    {
        setScore(score+1);
    }


    public void addDice(int numberOfSides)
    {
        die = new Dice(numberOfSides);
    }
}
