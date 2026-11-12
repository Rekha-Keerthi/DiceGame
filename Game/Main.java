package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static int getValidRounds(Scanner scanner){
        int numberOfRounds =0;
        while (numberOfRounds<=0) {
            try{
                 System.out.print("How many rounds do you want to play? ");
                    numberOfRounds = scanner.nextInt();

                if (numberOfRounds<=0) {
                    System.out.println("Please enter the a valid number");
                   
                    
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter the whole number");
                scanner.nextLine();
            }
            
        }
        return numberOfRounds;

    }

    public static int getNoOfSides(Scanner scanner){
    int sides =0;
        while (sides<2) {
            try{
                 System.out.print("How many sides the die should have? ");
                    sides = scanner.nextInt();

                if (sides<2) {
                    System.out.println("Die should be of atleast 2 sided die:");
                    
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter the whole number");
                scanner.nextLine();
            }
            
        }
        return sides;
    }


    public static int getValidGuess(Scanner scanner, int numberOfSides){
        int guess =0;
        while (guess <1 || guess >numberOfSides) {
            try{
                 System.out.println("\nGuess the die value between 1  to " + numberOfSides);
                    guess = scanner.nextInt();

                if (guess < 1 || guess >numberOfSides) {
                    System.out.println("Entered guess value is not in the range");
                    
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter the whole number");
                scanner.nextLine();
            }
            
        }
       return  guess;

    }

    private  static void playRounds(Scanner scanner , Player player, int noOfRounds, int  numberOfSides)
    {
        for ( int i = 1 ; i <= noOfRounds ; i++)
        {
           
            System.out.println("------------------------------------------------------");
            System.out.println("--------- Round number : " + i + " ---------");
            
            int guessedValue = getValidGuess(scanner, numberOfSides);
            
            player.rollDice();

            System.out.println("\n the random value from a die roll is : " + player.getDieValue());

            if ( guessedValue == player.getDieValue())
            {
                player.increaseScore();
                System.out.println("\nCorrect Guess! you have score 1 point " + player.getScore());
            }
            else
            {
                System.out.println("\nWrong Guess! you have score 0 point ");
            }
            scanner.nextLine();
        }
        
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the player name? ");
        String playername = scanner.next();
        Player player = new Player(playername);
        System.out.println("Welcome to Dice Game : " + player.getPlayerName());

        
        //call the gertValidRounds method
        int noOfRounds= getValidRounds(scanner);

        //calling the getNoOfSides method for user to enter the sides
        int numberOfSides = getNoOfSides(scanner);
        player.addDice(numberOfSides);
        System.out.println(player.getPlayerName() + " has chosen to play " + numberOfSides + " sided die game");

        playRounds(scanner, player, noOfRounds, numberOfSides);

        System.out.println("\nGame Over!");
        System.out.println("Final Score is : " + player.getScore());
        
        scanner.close();
    }
    
}
