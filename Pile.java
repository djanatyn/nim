public class Pile
{
    private int numMarbles;

    public Pile(int marbles)
    {
        numMarbles = marbles;
    }

    public int getMarbles()
    {
        return numMarbles;
    }

    public void removeMarbles(int marbles)
    {
        numMarbles -= marbles;
    }
}
