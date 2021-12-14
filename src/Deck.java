import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    //instance variables
    private ArrayList<Card> cards;

    //constructors
    public Deck()
    {
        cards = new ArrayList<Card>();
    }

    //brain method creates a full deck
    public void createFullDeck()
    {
        for(Suit cardSuit : Suit.values())
        {
            for(Value cardValue : Value.values())
            {
                Card card = new Card(cardSuit, cardValue);
                cards.add(card);
            }
        }
    }

    //shuffles the current deck
    public void shuffle()
    {
        ArrayList<Card> tempDeck = new ArrayList<Card>();

        Random random = new Random();
        int randIndex = 0;
        int deckSize = cards.size();
        for(int i = 0; i < deckSize; i++)
        {
            randIndex = random.nextInt((this.cards.size()- 1) + 1);
            tempDeck.add(this.cards.get(randIndex));

            this.cards.remove(randIndex);
        }

        this.cards = tempDeck;
    }

    public String toString()
    {
        String cardsList = "";
        for(Card card : this.cards)
        {
            cardsList += "\n" + card.toString();
        }
        return cardsList;
    }

    public void removeCard(int i)
    {
        this.cards.remove(i);
    }

    public Card getCard(int i)
    {
        return this.cards.get(i);
    }

    public void addCard(Card addCard)
    {
        this.cards.add(addCard);
    }

    //draw from the deck
    public void draw(Deck inputDeck)
    {
        this.cards.add(inputDeck.getCard(0));
        inputDeck.removeCard(0);
    }

    public int deckSize()
    {
        return this.cards.size();
    }

    public void moveAllToDeck(Deck moveTo)
    {
        int thisDeckSize = this.cards.size();

        for(int i = 0; i < thisDeckSize; i++)
        {
            moveTo.addCard(this.getCard(i));
        }
        for(int i = 0; i < thisDeckSize; i++)
        {
            this.removeCard(0);
        }
    }

    //returns total value of cards in deck
    public int cardsValue()
    {
        int totalValue = 0;
        int aces = 0;

        for(Card card : this.cards)
        {
            switch(card.getValue())
            {
                case TWO -> totalValue += 2;
                case THREE -> totalValue += 3;
                case FOUR -> totalValue += 4;
                case FIVE -> totalValue += 5;
                case SIX -> totalValue += 6;
                case SEVEN -> totalValue += 7;
                case EIGHT -> totalValue += 8;
                case NINE -> totalValue += 9;
                case TEN -> totalValue += 10;
                case JACK -> totalValue += 10;
                case QUEEN -> totalValue += 10;
                case KING -> totalValue += 10;
                case ACE -> aces += 1;
            }
        }

        for(int i = 0; i < aces; i++)
        {
            if(totalValue > 10)
            {
                totalValue += 1;
            }
            else
            {
                totalValue += 11;
            }
        }

        return totalValue;
    }
}
