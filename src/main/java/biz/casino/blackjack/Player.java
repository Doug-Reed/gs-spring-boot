package biz.casino.blackjack;

public class Player {

    private Hand hand;
    private int chips = 10000;
    private int bet;

    public int placeBet(){
        chips = chips - bet;
        return bet;
    }

    public void collectWinnings(int amt) {
        chips += amt;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
