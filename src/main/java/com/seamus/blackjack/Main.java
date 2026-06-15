package com.seamus.blackjack;


import com.seamus.blackjack.model.Deck;

public class Main {
    static void main() {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);


    }
}
