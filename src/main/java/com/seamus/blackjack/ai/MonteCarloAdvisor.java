package com.seamus.blackjack.ai;

import com.seamus.blackjack.model.Card;
import com.seamus.blackjack.model.Hand;
import java.util.Random;

public class MonteCarloAdvisor {
    private int[] deckCount;
    private int cardCount;
    private Random random = new Random();

    public MonteCarloAdvisor(){
        deckCount = new int[12];
    }

    public void buildPool(Hand hand, Card card){
        for (int i = 2; i < 12; i++){
            if (i == 10){
                deckCount[i] = 16;
            } else{
                deckCount[i] = 4;
            }
        }
        for (int i = 0; i < hand.size(); i++){
            int value = hand.getCard(i).getRank().getValue();
            deckCount[value]--;
        }
        deckCount[card.getRank().getValue()]--;
        cardCount = 0;
        for (int i = 2; i < 12; i++){
            cardCount += deckCount[i];
        }
    }

    public int drawCard(){
        int roll = random.nextInt(cardCount);   // each value has a block, 4 for most value 10 is 16 due to face cards
        int value = 2;
        while (roll >= deckCount[value]){   // if the roll is more than the block length it goes thorough block then remove block length from roll value
            roll -= deckCount[value];
            value++;
        }
        return value;
    }

    public int simulateDealerOnce(int upValue){
        int total = upValue;
        int aceCount = 0;
        if (upValue == 11) {
            aceCount++;
        }
        while (total < 17){
            int card = drawCard();
            if (card == 11){
                aceCount++;
            }
            total += card;
            while (total > 21 && aceCount > 0){
                total -= 10;
                aceCount--;
            }
        }
        return total;
    }

     public double standEV(int playerTotal, int upValue){
        double score = 0;
        int trials = 200_000;
         for (int i = 0; i < trials; i++){
             int dealer = simulateDealerOnce(upValue);
             if (dealer > 21){
                 score += 1;                  // dealer busted
             } else if (dealer < playerTotal){
                 score += 1;                  // your total is higher
             } else if (dealer > playerTotal){
                 score -= 1;                  // dealer's total is higher
             }
         }
         return score / trials;

     }

     public double doubleEV(int playerTotal, int playerAces, int upValue){
        double score = 0;
        int aceCount = 0;
        int total = playerTotal;
        int aces = playerAces;
         for (int i = 2; i <= 11; i++){
             double p = (double) deckCount[i] / cardCount; // what percent of every rank is the deck e.g 3/49 3's
             if(i == 11){
                 aceCount++;
             }
             playerTotal += i;
             while(playerTotal > 21 && aceCount > 0){
                 playerTotal -= 10;
                 aceCount--;
             }
//             if (total > 21){
//                 score += p * (-1);
//             } else {               NOT FULLY SURE
//                 score += p * standEV(total, upValue);
//             }
//         }
         return 2 * score;
     }


    public int getDeckCount(int value){
        return deckCount[value];
    }

    public int getCardCount(){
        return cardCount;
    }
}
