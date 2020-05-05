public abstract class Player {
    private String playerName;
    private Hand hand;


    public Player(String playerName, Hand hand){
        this.playerName = playerName;
        this.hand = hand;
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