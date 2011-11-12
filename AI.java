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
	System.out.println("The computer took two marbles.");
	return 2;
    }
}