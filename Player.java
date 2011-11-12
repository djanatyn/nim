import java.util.Scanner;

public class Player
{
    public int promptPlayer(int numMarbles)
    {
	Scanner in = new Scanner(System.in);
	Boolean success = false;
	int takeAmount = 0;
	System.out.println("There are " + numMarbles + " marbles left.");

	while (!success) {
	    System.out.print("> ");
	    takeAmount = in.nextInt();
	    if (takeAmount <= 0) {
		System.out.println("Nice try. Please enter an amount above zero.");
	    } else if (takeAmount > numMarbles) {
		System.out.println("There are only " + numMarbles + " marbles in the pile.");
	    } else {
		System.out.println("Okay, " + takeAmount + " marbles were taken from the pile.");
		success = true;
	    }
	}
	return takeAmount;
    }
}