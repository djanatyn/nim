import java.util.Scanner;
import java.util.Random;

public class Nim
{
    public static void main(String[] args)
    {
        startGame();
    }

    public static void startGame()
    {
        Scanner in = new Scanner(System.in);
	Random generator = new Random();
        int numPlayers = 1;
        Boolean smartComputer = true;
	Boolean twoPlayer = false;

        System.out.println("Nim");
        System.out.println("---");
        System.out.println("How many players:");
        System.out.println("a). One Player against Smart Computer,");
        System.out.println("b). One Player against Dumb Computer, or");
        System.out.println("c). Two Players?");
        String choice = in.nextLine();

        if (choice.toLowerCase().equals("a")) {
            System.out.println("Playing with a Smart Computer.");
            smartComputer = true;
        } else if (choice.toLowerCase().equals("b")) {
            System.out.println("Playing against a Dumb Computer.");
            smartComputer = false;
        } else if (choice.toLowerCase().equals("c")) {
            numPlayers = 2;
            System.out.println("Starting with two players.");
	    twoPlayer = true;
        } else {
            System.out.println("Error - please enter a, b, or c.");
            Nim.startGame();
        }
	
	int numMarbles = generator.nextInt(90) + 10;
	System.out.println("Playing with " + numMarbles + " marbles.");

	if (twoPlayer) {
	    twoPlayerGame(numMarbles);
	} else {
	    aiGame(smartComputer, numMarbles);
	}
    }

    public static void twoPlayerGame(int marbles)
    {
	Random generator = new Random();
	Scanner in = new Scanner(System.in);
	Boolean playerOneGoesFirst;
	Boolean playerOneWins = true;
	Player playerOne = new Player();
	Player playerTwo = new Player();
	Pile thePile = new Pile(marbles);
	if (generator.nextInt(2) == 1) {
	    System.out.println("Player one goes first.");
	    playerOneGoesFirst = true;
	} else {
	    System.out.println("Player two goes first.");
	    playerOneGoesFirst = false;
	}
	while (thePile.getMarbles() != 0) {
	    if (playerOneGoesFirst) {
		playerOneWins = false;
		System.out.println("Player One's Turn:");
		thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
		if (thePile.getMarbles() != 0) {
		    System.out.println("Player Two's Turn:");
		    thePile.removeMarbles(playerTwo.promptPlayer(thePile.getMarbles()));
		} else {
		    playerOneWins = true;
		}
	    } else {
		playerOneWins = true;
		System.out.println("Player Two's Turn:");
		thePile.removeMarbles(playerTwo.promptPlayer(thePile.getMarbles()));
		if (thePile.getMarbles() != 0) {
		    System.out.println("Player One's Turn:");
		    thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
		} else {
		    playerOneWins = false;
		}
	    }
	}
	
	if (playerOneWins) {
	    System.out.println("Player One Wins!");
	} else {
	    System.out.println("Player Two Wins!");
	}

	gameOverPrompt();
    }
	
    public static void aiGame(Boolean smartComputer, int marbles)
    {
	Random generator = new Random();
	Scanner in = new Scanner(System.in);
	Boolean playerGoesFirst;
	Boolean youWin = true;
	Player playerOne = new Player();
	Pile thePile = new Pile(marbles);
	AI theComputer = new AI(smartComputer);
	
	if (generator.nextInt(2) == 1) {
	    System.out.println("Computer goes first.");
	    playerGoesFirst = false;
	} else {
	    System.out.println("You go first.");
	    playerGoesFirst = true;
	}

	while (thePile.getMarbles() != 0) {
	    if (playerGoesFirst) {
		youWin = false;
		thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
		if (thePile.getMarbles() != 0) {
		    thePile.removeMarbles(theComputer.takeTurn(thePile.getMarbles()));
		} else {
		    youWin = true;
		}
	    } else {
		youWin = true;
		thePile.removeMarbles(theComputer.takeTurn(thePile.getMarbles()));
		if (thePile.getMarbles() != 0) {
		    thePile.removeMarbles(playerOne.promptPlayer(thePile.getMarbles()));
		} else {
		    youWin = false;
		}
	    }
	}

	if (youWin) {
	    System.out.println("You won!");
	} else {
	    System.out.println("You lost.");
	}

	gameOverPrompt();
    }
    
    public static void gameOverPrompt()
    {
	Scanner in = new Scanner(System.in);
	System.out.println("Play again? [Y/N]");
	String choice = in.nextLine();

	if (choice.toLowerCase().equals("y")) {
	    System.out.println("Restarting game...");
	    startGame();
	} else if (choice.toLowerCase().equals("n")) {
	    System.out.println("Bye!");
	} else {
	    System.out.println("Invalid choice, please try again.");
	    gameOverPrompt();
	}
    }
}