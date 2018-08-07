package biz.casino.blackjack;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private boolean soft = false;

    public void addCards(Card card){
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isSoft() {
        for(int x = 0; x < getDisplay().length(); x++){
            Character c = getDisplay().charAt(x);
            if(c.equals("A")) {
                soft = true;
                return soft;
            }
        }
        return soft;
    }

    public String getDisplay(){
        StringBuffer sb = new StringBuffer();
        for(Card card:cards) {
            sb.append(card.getDisplay() + " ");
        }
        return sb.toString();
    }

    public boolean firstTwoCards(){
        return (cards.size()==2);
    }

    public int getValue(){
        int value = 0;
        for(Card card: cards){
            value += card.getValue();
        }

        if (value > 21) {
            for(int x = 0; x < getDisplay().length(); x++){
                Character c = getDisplay().charAt(x);
                if(c.equals("A")) {
                    value -= 10;
                    if(value < 21) {
                        return value;
                    }
                }
            }
        }

        return value;
    }
}
