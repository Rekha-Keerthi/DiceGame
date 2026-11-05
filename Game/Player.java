package Game;

public class Player {
    private String playerName;
    private int score;
    private Die dice;
    
    
    Player(String playerName)
    {
        this.playerName = playerName;
        this.score =0;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void addDie(int numberOfSides)
    {
        dice = new Die(numberOfSides);
    }

    public void rollDice(){
        dice.roll();
    }
    
    public int getDieValue(){
        return dice.getCurrentValue();
    }
public void increaseScore(){
    score++;

}
}
