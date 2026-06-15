package com.seamus.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
        System.out.println(deck);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Card card : deck) {
            stringBuilder.append(card).append("\n");
        }
        return stringBuilder.toString();
    }
}

