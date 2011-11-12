import java.util.Random;

public class AI
{

    private Boolean amISmart;

    public AI(Boolean smartComputer)
    {
	if (smartComputer) {
	    amISmart = true;
	} else {
	    amISmart = false;
	}
    }

    public int takeTurn(int numMarbles)
    {
	int takeAmount = 1;
	Random generator = new Random();

	if (amISmart) {
	    for (int i = 1; i <= (numMarbles / 2); i++) {
		int t = numMarbles - i;
		if (t == 3 || t == 7 || t == 15 || t == 31 || t == 63) {
		    takeAmount = i;
		}
	    }
	    if (takeAmount == 0) {
		takeAmount = generator.nextInt((numMarbles / 2) - 1) + 1;
	    }
	} else {
	    takeAmount = generator.nextInt((numMarbles / 2) - 1) + 1;
	}

	System.out.println("The computer took " + takeAmount + " marbles.");
	return takeAmount;
    }
}
