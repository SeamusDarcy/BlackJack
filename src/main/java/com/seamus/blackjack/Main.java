package com.seamus.blackjack;


import com.seamus.blackjack.ai.MonteCarloAdvisor;
import com.seamus.blackjack.game.Game;
import com.seamus.blackjack.model.*;

public class Main {
    static void main() {
        //Game game = new Game();
        //game.play();

        MonteCarloAdvisor adv = new MonteCarloAdvisor();

        Hand player = new Hand();
        player.addCard(new Card(Suit.SPADES, Rank.TWO));
        player.addCard(new Card(Suit.HEARTS, Rank.THREE));
        Card up = new Card(Suit.CLUBS, Rank.FOUR);
        adv.buildPool(player, up);

        System.out.println(adv.standEV(20, 6));
        System.out.println(adv.standEV(16, 10));


    }
}
