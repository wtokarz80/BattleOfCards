public abstract class Player {
    private String playerName;
    private Hand hand;
    private boolean canPlay;
    private Card currentCard;


    public Player(String playerName, Hand hand){
        this.playerName = playerName;
        this.hand = hand;
    }

    public void ifCanPlay(boolean canPlay){
        this.canPlay = canPlay;
    }

    public Hand getHand() {
        return hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setName(String name){
        this.playerName = name;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public Card showCurrentCard(){
        Card card = hand.getHandList().get(0);
        hand.getHandList().remove(0);
        return currentCard;
}

    abstract void chooseStatistic();

}