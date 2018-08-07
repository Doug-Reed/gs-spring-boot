package biz.casino.blackjack;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        for(int i=1; i<5; i++){
            Card two = new Card();
            two.setDisplay("2");
            two.setValue(2);

            cards.add(two);

            Card three = new Card();
            three.setDisplay("3");
            three.setValue(3);

            cards.add(three);

            Card four = new Card();
            four.setDisplay("4");
            two.setValue(4);

            cards.add(four);

            Card five = new Card();
            three.setDisplay("5");
            three.setValue(5);

            cards.add(five);

            Card six = new Card();
            two.setDisplay("6");
            two.setValue(6);

            cards.add(six);

            Card seven = new Card();
            three.setDisplay("7");
            three.setValue(7);

            cards.add(seven);

            Card eight = new Card();
            three.setDisplay("8");
            three.setValue(8);

            cards.add(eight);

            Card nine = new Card();
            four.setDisplay("9");
            two.setValue(9);

            cards.add(nine);

            Card ten = new Card();
            three.setDisplay("10");
            three.setValue(10);

            cards.add(ten);

            Card jack = new Card();
            two.setDisplay("J");
            two.setValue(10);

            cards.add(jack);

            Card queen = new Card();
            three.setDisplay("Q");
            three.setValue(10);

            cards.add(queen);

            Card king = new Card();
            four.setDisplay("K");
            two.setValue(10);

            cards.add(king);

            Card ace = new Card();
            three.setDisplay("A");
            three.setValue(11);

            cards.add(ace);
        }
    }
}
