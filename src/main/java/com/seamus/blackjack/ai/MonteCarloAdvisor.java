package com.seamus.blackjack.ai;

import com.seamus.blackjack.model.Card;
import com.seamus.blackjack.model.Hand;

public class MonteCarloAdvisor {
    public int[] deckCount;
    public int cardCount;

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
}
