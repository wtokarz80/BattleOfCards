import java.util.*;

public class ComputerPlayer extends Player {


    public ComputerPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }

    public void addNames(){

    }


    @Override
    public String chooseStatistic() {
        loading();
        Card card = super.showCurrentCard();
        Map<String, Integer> cardStats;
        cardStats = new LinkedHashMap<>();
        cardStats.put("strength", card.getStrength());
        cardStats.put("intelligence", card.getIntelligence());
        cardStats.put("agility", card.getAgility());
        cardStats.put("charisma", card.getCharisma());

        String playForAttribute = cardStats.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();

        return playForAttribute;
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void loading() {
        System.out.println("COMPUTER TURN....THINKING......\n");
        for (int i = 0; i < 20; i++) {
            System.out.print("\u25AE");
            wait(80);
        }
        System.out.println("\n\n");
    }
}
