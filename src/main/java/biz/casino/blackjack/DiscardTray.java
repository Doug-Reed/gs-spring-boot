package biz.casino.blackjack;

import java.util.ArrayList;

public class DiscardTray {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public void discard(Card c){
        cards.add(c);
    }

    public int traySize(){
        return cards.size();
    }
}
