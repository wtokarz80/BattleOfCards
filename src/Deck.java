import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

    public void dealCards(int numberOfCards){
        Iterator<Card> iterator = cardList.iterator();
        for (int i = 0; i < numberOfCards; i++){
            if (iterator.hasNext()) {
                Card card = iterator.next();
                hand.addCard(card);
                iterator.remove();
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }


}
