package com.seamus.blackjack.game;

import com.seamus.blackjack.model.Card;
import com.seamus.blackjack.model.Deck;
import com.seamus.blackjack.model.Hand;
import com.seamus.blackjack.ui.ConsoleUI;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private ConsoleUI ui;

    public Game(){
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
        ui = new ConsoleUI();

    }

    public void dealOpeningHands(){
        for (int i = 0 ; i <2 ; i++){
            playerHand.addCard(deck.deal());
            dealerHand.addCard(deck.deal());
        }
    }

    public void playerTurn(){
        ui.showPlayerHand(playerHand);
        ui.showDealerCard(dealerHand);

        while (true){
            if (ui.askHitOrStand()){
                playerHand.addCard(deck.deal());
                ui.showPlayerHand(playerHand);
                if (playerHand.getTotal()>21){
                    ui.printBust();
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void dealerTurn(){
        ui.showDealerHand(dealerHand);
        while (dealerHand.getTotal() < 17){
            dealerHand.addCard(deck.deal());
            ui.showDealerHand(dealerHand);
            if (dealerHand.getTotal() > 21){
                ui.printDealerBust();
            }
        }
    }

    public int playerWin(){
        // 1 : win, 2 : loss, 3 : draw
        if (playerHand.getTotal()>21){
            return 2;
        }
        if (dealerHand.getTotal()>21){
            return 1;
        }
        if (playerHand.getTotal() == dealerHand.getTotal()){
            return 3;
        } else if (playerHand.getTotal() > dealerHand.getTotal()){
            return 1;
        } else return 2;

    }
    public void play() {
        dealOpeningHands();
        playerTurn();
        if (playerHand.getTotal() <= 21) {
            dealerTurn();
        }
        int result = playerWin();
        switch (result){
            case 1:
                ui.printWin();
                break;
            case 2:
                ui.printLoss();
                break;
            case 3:
                ui.printDraw();
                break;
            default:
                ui.printError();
                break;

        }
    }
}


