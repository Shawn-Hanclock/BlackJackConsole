public class Card
{
    //instance variables
    private String name;
    private int cardsValue;

    public Card(String name)
    {
        this.name = name;
        this.cardsValue = 0;
    }

    //getters
    public String getName()
    {
        return name;
    }
    public int getCardsValue()
    {
        return cardsValue;
    }

    //setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setCardsValue(int cardsValue)
    {
        this.cardsValue = cardsValue;
    }
}
