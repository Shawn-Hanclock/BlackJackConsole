public class Card
{
    private Suit suit;
    private Value value;
    
    public Card(Suit suit, Value value)
    {
        this.value = value;
        this.suit = suit;
    }

    public String toString()
    {
      return this.suit + "-" + this.value + "\n";
    }

    public String toValue()
    {
        return this.value + "";
    }
}
