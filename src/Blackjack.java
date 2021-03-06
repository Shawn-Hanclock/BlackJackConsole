import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    //title in console
    System.out.println("-----------CONSOLE BLACKJACK-----------");

      //card dealing deck
    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle();

      //dealer's deck
    Deck playerDeck = new Deck();
    Deck dealerDeck = new Deck();

    //using the compareto
    System.out.println("Type '1' for special prize :)");
    Scanner userInput = new Scanner(System.in);
    int prize = userInput.nextInt();
    if(prize == 1)
    {
      System.out.println(playingDeck.compareTo(playerDeck) + "\n");
    }
    else
    {
      System.out.println("no prize for you");
    }

    //inital value of money
    double playerMoney = 100.00;

    //Scanner userInput = new Scanner(System.in);
    //game loop
    while(playerMoney > 0)
    {
      playingDeck.shuffle();

      double playerBet = 0;
      System.out.println("You have $" + playerMoney + ", how much do you want to bet, enter an integer value:");  
      double input = (double) userInput.nextDouble();
      if(input < 0)
      {
        System.out.println("not a valid input");
        playerMoney = 0;
      }
      else if(input > playerMoney)
      {
        playerBet = playerMoney;
      }
      playerBet = input;
      System.out.println("\nYou bet, $" + playerBet);
      
      System.out.println();

      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);

      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);


      System.out.println("-----------CARDS DEALT-----------");
      System.out.print("Your cards are: ");
      System.out.println(playerDeck);

      System.out.println("The dealer has: ");
      System.out.println(dealerDeck.getCard(0).toString() + " [Hidden Card]\n");

      boolean endRound = false;
      boolean playerBust = false;


      System.out.println("-----------PLAYER's TURN-----------");
      while(!endRound)
      {
        //player choice
        
        System.out.println("Do you want to stand(1) or hit(2)?");
        int playerChoice = userInput.nextInt();
        System.out.println();

        //plyer decided to stand on their hand
        if(playerChoice == 1)
        {
          endRound = true;
        } //end of if 
        //player decides to hit
        else if(playerChoice == 2 )
        {
          //draw a card
          playerDeck.draw(playingDeck);

          //display new cards 
          System.out.print("Your new cards are: ");
          System.out.println(playerDeck);
          System.out.println("Your hand's total value is, " +  playerDeck.deckTotalVal());
          
          // if to check if the player busts
          if(playerDeck.deckTotalVal() > 21)
          {
            System.out.println("You bust.\n");
            playerBust = true;
            endRound = true;
          }//end of if
          //calculate the card total
        }//end of else if
      }//end of game loop for each round
      //checks if player has bust
      
      //condition if the player did not busted
      if(!playerBust)
      {

      System.out.println("-----------DEALER's TURN-----------");
      System.out.print("The dealer has: ");
      System.out.println(dealerDeck);
      System.out.println("Dealer's total value is, " +  dealerDeck.deckTotalVal() + "\n");

      //boolen if the dealer started to bust
      boolean dealerBust = false;

      //dealer draws cards until value passes 17
      while(dealerDeck.deckTotalVal() < 17)
      {
        dealerDeck.draw(playingDeck);
        System.out.print("The dealer draws a card: ");
        System.out.println(dealerDeck);
        System.out.println("Dealer's total value is, " +  dealerDeck.deckTotalVal());
        if(dealerDeck.deckTotalVal() > 21)
        {
          dealerBust = true;
        } //checks if dealer bust
      }
      
      //results for dealer busts
      if(dealerBust)
      {
        System.out.println();
        System.out.println("-----------RESULTS-----------");
        System.out.println("You win this hand dealer bust, you gain $" + playerBet + "\n");
        playerMoney += playerBet;
      }//end of if
      //reulsts for tieing hands
      else if(dealerDeck.deckTotalVal() == playerDeck.deckTotalVal())
      {
        System.out.println();
        System.out.println("-----------RESULTS-----------");
        System.out.println("No one wins this hand both hands valued the same, you lose no money\n");
      }//end of else if
      //dealer wins by value
      else if(dealerDeck.deckTotalVal() > playerDeck.deckTotalVal())
      {
        System.out.println();
        System.out.println("-----------RESULTS-----------");
        System.out.println("Dealer wins this hand, you lose $" + playerBet + "\n");
        playerMoney -= playerBet;
      }//end of else else if
      //dealer loses by value
      else if(dealerDeck.deckTotalVal() < playerDeck.deckTotalVal())
      {
        System.out.println();
        System.out.println("-----------RESULTS-----------");
        System.out.println("You win this hand, you gain $" + playerBet + "\n");
        playerMoney += playerBet;
      }//end of else else else if

      }//end of !playerbust if
      if (playerBust)
      {
        System.out.println();
        System.out.println("-----------RESULTS-----------");
        System.out.println("Dealer wins this hand you bust, you lose $" + playerBet + "\n");
        playerMoney -= playerBet;
      }//end if the player busts

      //moves cards back to the deck
      playerDeck.moveAllToDeck(playingDeck);
      dealerDeck.moveAllToDeck(playingDeck);
    }//end of game loop
    System.out.println("You Lost all your Money");
  }//end of main method
}//end of main class
