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



    @Override
    public String toString() {
        return "Hand{" +
                "handList=" + handList +
                '}';
    }
}
