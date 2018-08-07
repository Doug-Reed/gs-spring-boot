package biz.casino.blackjack;

public class Count {

    private Shoe shoe;

    public int getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(Hand hand) {
        for (Card card: hand.getCards()){
            if(card.getValue() >= 10) {
                runningCount -= 1;
            }

            if(card.getValue() < 7) {
                runningCount += 1;
            }
        }
    }

    public Count(Shoe shoe){
        this.shoe = shoe;
    }

    public int getTrueCount() {
        int factor = shoe.getCards().size();
        int divisor = factor/ shoe.decksInAShoe;

        trueCount = runningCount/divisor;

        return trueCount;
    }

    private int runningCount = 0;

    private int trueCount = 0;
}
