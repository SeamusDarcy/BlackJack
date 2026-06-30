package com.seamus.blackjack.ui;

import com.seamus.blackjack.model.Hand;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
    }

    public void showPlayerHand(Hand hand){
        System.out.println("Player's Hand : ");
        System.out.println(hand);
        System.out.println("Total : " + hand.getTotal());
        System.out.println();
    }

    public void showDealerHand(Hand hand){
        System.out.println("Dealer's Hand : ");
        System.out.println(hand);
        System.out.println(hand.getTotal());
    }

    public void showDealerCard(Hand hand){
        System.out.println("Dealer's Hand : ");
        System.out.println(hand.getCard(0));
    }

    public boolean askHitOrStand(){
        System.out.println("1 to stand, 2 to hit : ");
        String input = scanner.nextLine();
        return input.equals("2");
    }

    public void printBust(){
        System.out.println("Bust!");
    }

    public void printDealerBust(){
        System.out.println("Dealer Bust!");

    }

    public void printWin(){
        System.out.println("You Win!");
    }

    public void printLoss(){
        System.out.println("You Loose");
    }

    public void printDraw(){
        System.out.println("Draw");
    }

    public void printError(){
        System.out.println("System Error");
    }

}
