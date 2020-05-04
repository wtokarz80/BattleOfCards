import java.util.Comparator;

public class CardIntelligenceComparator implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        int result = o1.getIntelligence() - o2.getIntelligence();
        return result;
    }
}
