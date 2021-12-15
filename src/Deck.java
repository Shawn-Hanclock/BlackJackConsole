import java.util.ArrayList;
import java.util.Random;

public class Deck implements Comparable
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
        int deckSize = this.cards.size();
        for(int i = 0; i < deckSize; i++)
        {
            randIndex = random.nextInt((this.cards.size()- 1) + 1);
            tempDeck.add(this.cards.get(randIndex));

            this.cards.remove(randIndex);
        }

        this.cards = tempDeck;
    }

       //formated string tostring
    public String toString()
    {
        String cardsList = "\n";
        for(Card card : this.cards)
        {
            cardsList += card.toString() + " ";
        }
        return cardsList;
    }

       //removes a card in a certain place in a hand
    public void removeCard(int i)
    {
        this.cards.remove(i);
    }//end of remove card

    //gets a card at a place in a hand
    public Card getCard(int i)
    {
        return this.cards.get(i);
    }//end of get card

    //adds a card
    public void addCard(Card addCard)
    {
        this.cards.add(addCard);
    }//end of addcard

    //draw from the deck
    public void draw(Deck inputDeck)
    {
      this.cards.add(inputDeck.getCard(0));
      inputDeck.removeCard(0);
    }//end of draw method that draws cards from a given deck

    public int deckSize()
    {
      return this.cards.size();
    }//end of deckSize

       //moves all the cards of one deck to another
    public void moveAllToDeck(Deck moveTo)
    {
        int thisDeckSize = this.cards.size();

        //loops for deck size
        for(int i = 0; i < thisDeckSize; i++)
        {
            moveTo.addCard(this.getCard(i));
        }
        //loops for the deckSize
        for(int i = 0; i < thisDeckSize; i++)
        {
            this.removeCard(0);
        }
    }//end of moveall to deck

    //calculates the total value of a hand
    public int deckTotalVal()
    {
      int totalVal = 0;
      int acesTotal = 0;
      //loops through all card objects in hand
      for(Card cardCurrent : this.cards)
      {
        //String transverseStr = cardCurrent.getValue());
        if(cardCurrent.toValue().equals(Value.TWO.toString())) 
        totalVal += 2;
        if(cardCurrent.toValue().equals(Value.THREE.toString())) 
        totalVal += 3;
        if(cardCurrent.toValue().equals(Value.FOUR.toString())) 
        totalVal += 4;
        if(cardCurrent.toValue().equals(Value.FIVE.toString())) 
        totalVal += 5;
        if(cardCurrent.toValue().equals(Value.SIX.toString())) 
        totalVal += 6;
        if(cardCurrent.toValue().equals(Value.SEVEN.toString())) 
        totalVal += 7;
        if(cardCurrent.toValue().equals(Value.EIGHT.toString())) 
        totalVal += 8;
        if(cardCurrent.toValue().equals(Value.NINE.toString())) 
        totalVal += 9;
        if(cardCurrent.toValue().equals(Value.TEN.toString())) 
        totalVal += 10;
        if(cardCurrent.toValue().equals(Value.JACK.toString())) 
        totalVal += 10;
        if(cardCurrent.toValue().equals(Value.QUEEN.toString())) 
        totalVal += 10;
        if(cardCurrent.toValue().equals(Value.KING.toString())) 
        totalVal += 10;
        if(cardCurrent.toValue().equals(Value.ACE.toString())) 
        acesTotal += 1;
      }//end of for each loop
      //loops for each number of aces in a hand
      for(int i = 0; i < acesTotal; i++)
      {
        if(totalVal > 10)
        {
          totalVal += 1;
        }
        else
        {
          totalVal += 11;
        }
      }//end of loop
      return totalVal;
    }//end of deckTotalVal
    
  @Override
    public int compareTo(Object card) 
    {
        int output = 0;
        if(this.cards.size() < ((Deck)card).deckSize())
        {
            output = -1;
        }//end of if
        else if(this.cards.size() > ((Deck)card).deckSize())
        {
            output = 1;
        }//end of else if
        return output;
    }//end of compareto
}//end of deck class
