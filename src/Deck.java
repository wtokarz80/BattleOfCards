import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cardList;

    public Deck(){
        this.cardList = new ArrayList<>();
    }

    public void addCard(Card card){
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }
}
