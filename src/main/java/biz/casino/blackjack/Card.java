package biz.casino.blackjack;

public class Card {
    private int value;
    private String display;
    private boolean aceEqualsOne = false;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setAceEqualsOne(boolean doesAceEqualOne) {
        this.aceEqualsOne = doesAceEqualOne;
    }

    public boolean getAceEqualsOne() {
        return aceEqualsOne;
    }
}
