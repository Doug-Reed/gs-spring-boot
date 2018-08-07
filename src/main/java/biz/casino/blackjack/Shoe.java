package biz.casino.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Shoe {

    public final int decksInAShoe = 6;

    public Card draw(){
        Card card = cards.remove(cards.size());
        return card;
    }

    private ArrayList<Card> cards;

    public void reload(){

        cards.clear();

        for (int i = 1; i <= decksInAShoe; i++){
            Deck deck = new Deck();
            cards.addAll(deck.getCards());
        }

        shuffle();
    }

    public Shoe(){
        reload();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
