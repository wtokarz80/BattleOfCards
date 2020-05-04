import java.util.Comparator;

public class CardCharismaComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        int result = o1.getCharisma() - o2.getCharisma();
        return result;
    }
}
