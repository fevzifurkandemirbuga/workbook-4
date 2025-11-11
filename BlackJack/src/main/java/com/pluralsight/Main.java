package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();


        System.out.print("number of players: ");
        int numOfPlayers = scan.nextInt();
        scan.nextLine();

        ArrayList<Hand> games = new ArrayList<>();

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Please enter the name for player-"+(i+1) +": ");
            String name= scan.nextLine();
            Hand hand = new Hand(name);

            Card initialCard1 = deck.deal();
            Card initialCard2 = deck.deal();

            hand.deal(initialCard1);
            hand.deal(initialCard2);
            games.add(hand);

        }
        boolean game = true;
        int losers = 0;
        int stay=0;



        while (game) {
            for (Hand h:games) {
                if (losers == numOfPlayers) {
                    System.out.println("everyone lost");
                    game = false;
                    break;
                }
                else if(losers+stay==numOfPlayers){
                  Hand winner=games.get(0);
                  for(Hand hand:games){
                      if (winner.getValue()<hand.getValue()){
                          winner=hand;
                      }
                  }
                    System.out.println("\n\n\n"+winner.getPlayer()+" is the winner");
                  game=false;
                  break;
                }
                else if (h.getValue() > 21) {
                    continue;
                }

                h.display();

                System.out.print("(H)it or(S)tay: ");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("h")) {
                    h.deal(deck.deal());
                    h.display();
                    if (h.getValue() > 21) {
                        System.out.println("you lost");
                        losers++;
                    } else if (h.getValue() == 21) {
                        System.out.println(h.getPlayer()+ " win");
                        game = false;

                    }
                } else {
                    stay++;
                }
            }


        }
    }





}
