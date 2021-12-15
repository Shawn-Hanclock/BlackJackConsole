public class Card
{
    //initalization variables
    private Suit suit;
    private Value value;
    
    //constructor
    public Card(Suit suit, Value value)
    {
        this.value = value;
        this.suit = suit;
    }//end of constructor

    //tostring
    public String toString()
    {
      return this.suit + "-" + this.value + "\n";
    }//end of toString

    //method that returns value as string instead of enum
    public String toValue()
    {
        return this.value + "";
    }//end of toValue method
}//end of card class
