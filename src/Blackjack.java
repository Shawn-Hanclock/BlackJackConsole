import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        System.out.println("Console Blackjack\n");

        //card dealing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //player's deck
        Deck playerDeck = new Deck();
        //dealer's deck
        Deck dealerDeck = new Deck();

        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

        //game code
        while(playerMoney > 0)
        {
            System.out.println("How much do you want to bet, you have $" + playerMoney);
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney)
            {
                System.out.println("You cannot bet more than you have." + playerMoney);
                break;
            }

            boolean endRound = false;

            //deal cards to player
            playerDeck.draw(playerDeck);
            playerDeck.draw(playerDeck);

            //dealer gets two cards
            dealerDeck.draw(playerDeck);
            dealerDeck.draw(playerDeck);
            while(true)
            {
                System.out.println("Your Hand:");
                System.out.println(playerDeck);
                System.out.println("Your deck is valued at: " + playerDeck.cardsValue());

                //display dealer hand
                System.out.println("Dealer Hanc: " + dealerDeck.getCard(0) + "[Hidden Card]");

                //player turn to hit or stand
                System.out.println("Would you like to (1)Hit or (2)Stand?");
                int response = userInput.nextInt();

                //user hits
                if(response == 1)
                {
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if(playerDeck.cardsValue() > 21)
                    {
                        System.out.println("Bust. Current deck value of, " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                    }
                }

                if(response == 2)
                {
                    break;
                }
            }

            //reveal dealer cards
            System.out.println("Deaker Cards: " + dealerDeck.toString());
            //See if dealer has more points than player
            if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && !endRound)
            {
                System.out.println("Dealer wins");
                playerMoney -= playerBet;
                endRound = true;
            }

            //dealer draws at 16
            while((dealerDeck.cardsValue() < 17) && !endRound)
            {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }
            //display total valye for dealer
            System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());

            //deter if dealer busted
            if((dealerDeck.cardsValue() > 21) && !endRound)
            {
                System.out.println("Dealer Bust. You win.");
                playerMoney += playerBet;
                endRound = true;
            }
            //deter if push
            if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && !endRound)
            {
                System.out.println("Push");
                endRound = true;
            }

            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && !endRound)
            {
                System.out.println("You win the hand");
                playerMoney += playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("end of hand");
        }

        System.out.println("game over");
    }
}
