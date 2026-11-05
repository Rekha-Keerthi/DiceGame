
package Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        System.out.println("===WELCOME TO THE DICE GAME===");
        
        Scanner scanner = new Scanner(System.in);
        boolean invalidInput =true;

                //Ask how many rounds the user wants to play
                System.out.print("How many rounds do you want to play?: \n");
                int numberOfRounds = scanner.nextInt();

                //Adding try catch block when user enters less than zero or zero value , to ask again the user to enter valid whole integer to continue the game
                    while(invalidInput)
                    {
                        try{
                        
                        if(numberOfRounds <= 0)
                        {
                            System.out.println("User must enter the valid whole number.\n");
                            System.out.print("How many rounds do you want to play?: \n");
                            numberOfRounds = scanner.nextInt();

                            if (numberOfRounds<=0) {
                                System.out.println("Rounds must be greater than 0.");
                            }
                        }
                        else
                            {
                                invalidInput = false;
                            }
                     }catch (InputMismatchException e)
                    {
                    System.out.println("User must enter the valid whole number.");
                    scanner.nextLine();
                    }
                }
               


               
                 //Ask how many sides of the die the user have
                System.out.print("How many sides does your die have?: ");
                int sides = scanner.nextInt();  

                //Ask players name
                System.out.print("Enter the name of the player: ");
                String playerName = scanner.next();

                //Create a player
                Player player = new Player(playerName);

                //Give player a die
                player.addDie(sides);

                System.out.println("Welcome " + player.getPlayerName() + " ! The player has choosen " + sides + " sided die.");

                //Play game

                for (int i = 1; i <= numberOfRounds; i++) {

                System.out.println("\nRound " + i);

                System.out.print("Guess a number between 1 and " + sides + ": ");

                int guessOfThePlayer = scanner.nextInt();

                player.rollDice();

                int result = player.getDieValue();

                System.out.println("The die rolled: " + result);

                if(guessOfThePlayer == result){

                    player.increaseScore();

                    System.out.println("Correct guess! You get 1 point for each correct guess."
                        +"\nCurrent score is: " + player.getScore()
                    );
                }
                else if ( guessOfThePlayer > sides) {
                    player.decreaseScore();
                    System.out.println("Guessed score is greater than result, so you get minus 1 point." +
                        "\nCurrent score is: " + player.getScore()
                    );
                    

                }else
                {
                    System.out.println("Wrong guess!! No point scored" + 
                    "\nCurrent score is: " + player.getScore());
                }
            
            }

            System.out.println(numberOfRounds + " rounds are now completed");

            System.out.println("Your final score is: " + player.getScore());

            System.out.println("\n===GAME OVER===");

            scanner.close();
    
}
}