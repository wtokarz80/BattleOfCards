import java.util.Comparator;

public class CardStrengthComparator implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        int result = o1.getStrength() - o2.getStrength();
        return result;
    }
}
