import java.util.Iterator;

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

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public Card showCurrentCard(){
        Card card = hand.getHandList().get(0);
        return card;
    }

    public  void removeCard(Card card){
        hand.getHandList().remove(card);
    }

    abstract String chooseStatistic();

}
