public abstract class Player {
    private String playerName;
    private Hand hand;
    private boolean isAvailable;

    public Player(String playerName, Hand hand, boolean isAvailable){
        this.playerName = playerName;
        this.hand = hand;
        this.isAvailable = isAvailable;
    }

    public Hand getHand() {
        return hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    abstract void setName(String name);  //abstract, because computer will have default name

    public String showCurrentCard(){
        return hand.getHandList().get(0).toString();
}
    abstract void chooseStatistic();

}