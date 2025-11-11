package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private Player player=new Player();
    private ArrayList<Card> cards;
    private int aces=0;
    public Hand(String name){
        this.player.setName(name);
        cards = new ArrayList<>();
    }
    // A Card is dealt to the Hand and the Hand is responsible
// to store the card
    public void deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
    public int getValue(){
        int value = 0;
        for(Card card: cards){
            card.flip(); // turn the card over to see the value
            if(card.getPointValue()==11){
                aces++;
            }
            while(aces>0 && (value+card.getPointValue()>21)){
                value-=10;
                aces--;
            }
            value += card.getPointValue();
            card.flip(); // hide the card again
        }
        return value;
    }

    public Player getPlayer() {
        return player;
    }

    public void display() {
        System.out.println("***********************************");
        System.out.println(player);
        for(Card c:cards) {
            System.out.print(c);
        }
        System.out.println("This hand is worth " + getValue());
        System.out.println("***********************************");


    }
}


