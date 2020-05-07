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

    public void shuffle(){
        Collections.shuffle(cardList);
        System.out.println("CARD SHUFFLING\n");
        for(int i = 0; i < 20; i++){
            System.out.print("\u25AE");
            wait(100);
        }
        System.out.println("\n\n");


    }

    public void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
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
