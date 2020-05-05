import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList;
    private Hand hand;

    public Deck(){
        this.cardList = new ArrayList<>();
        hand = new Hand();
    }

    public void addCard(Card card){
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public Hand getHand() {
        return hand;
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    public void dealCards(int numberOfCards){
        for (int i = 0; i < numberOfCards; i++) {
            Card card = cardList.get(i);
            hand.addCard(card);
//            cardList.remove(i);
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }
}
