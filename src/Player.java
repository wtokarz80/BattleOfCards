import java.util.Iterator;

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
        Iterator<Card> iterator = hand.getHandList().iterator();
        if (iterator.hasNext()){
            Card currentCard = iterator.next();
            return currentCard;
        }

//        if (hand.getHandList().size() > 0){
//            Card card = hand.getHandList().get(0);
//            return card;
//        }
        return null;
    }
    public  void removeCard(Card card){
        hand.getHandList().remove(card);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    abstract String chooseStatistic();

}
//    public Hand dealCards(int numberOfCards){
//
//        if (numberOfCards > cardList.size() || numberOfCards <= 0){
//            numberOfCards = cardList.size();
//        }
//        Iterator<Card> iterator = cardList.iterator();
//        for (int i = 0; i < numberOfCards; i++){
//            if (iterator.hasNext()) {
//                Card card = iterator.next();
//                hand.addCard(card);
//                iterator.remove();
//            }
//        }
//        return hand;
//    }