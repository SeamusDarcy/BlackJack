package com.seamus.blackjack.model;


public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString(){
        return this.rank + " of " + this.suit;
    }
}
