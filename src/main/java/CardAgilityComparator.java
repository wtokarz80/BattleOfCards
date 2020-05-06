import java.util.Comparator;

public class CardAgilityComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        int result = o1.getAgility() - o2.getAgility();
        return result;
    }
}
