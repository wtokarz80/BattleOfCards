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

    public void setName(String name){
        this.playerName = name;
    }

    public String showCurrentCard(){
        return hand.getHandList().get(0).toString();
}
    abstract void chooseStatistic();

}