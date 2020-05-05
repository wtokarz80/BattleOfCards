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

    public Hand dealCards(int numberOfCards){

        if (numberOfCards > cardList.size() || numberOfCards <= 0){
            numberOfCards = cardList.size();
        }
        Iterator<Card> iterator = cardList.iterator();
        for (int i = 0; i < numberOfCards; i++){
            if (iterator.hasNext()) {
                Card card = iterator.next();
                hand.addCard(card);
                iterator.remove();
            }
        }
        return hand;
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

    public void removeCard(int i){
        cardList.remove(i);
    }

    public int getSize(){
        return cardList.size();
    }

    public Card getCardByIndex(int k){
        return cardList.get(k);
    }


}
