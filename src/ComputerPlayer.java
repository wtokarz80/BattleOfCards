import java.util.*;

public class ComputerPlayer extends Player {


    public ComputerPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }


    @Override
    public String chooseStatistic() {
        Card card = super.showCurrentCard();
        Map<String, Integer> cardStats;
        cardStats = new LinkedHashMap<>();
        cardStats.put("Strength", card.getStrength());
        cardStats.put("Intelligence", card.getIntelligence());
        cardStats.put("Agility", card.getAgility());
        cardStats.put("Charisma", card.getCharisma());

        String playForAttribute = cardStats.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();
        int valueOfPlayAttribute = cardStats.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getValue();

        return playForAttribute;
    }
}
