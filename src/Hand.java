import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> handList;


    public Hand(){
        this.handList = new ArrayList<>();
    }

    public void addCard(Card card){
        handList.add(card);
    }

    public List<Card> getHandList() {
        return handList;
    }

    public Card putCardOnTable(){
        Card card = handList.get(0);
        handList.remove(0);
        return card;
    }



    @Override
    public String toString() {
        return "Hand{" +
                "handList=" + handList +
                '}';
    }
}
