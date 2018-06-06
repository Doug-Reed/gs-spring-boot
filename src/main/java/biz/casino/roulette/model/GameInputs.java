package biz.casino.roulette.model;

public class GameInputs {
    private int bet=0;
    private String spin = "ZERO";

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getSpin() {
        return spin;
    }

    public void setSpin(String spin) {
        this.spin = spin;
    }
}