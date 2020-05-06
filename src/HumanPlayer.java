import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }

//    @Override
//    public String chooseStatistic() {
//        Card card = super.showCurrentCard();
//        Map<String, Integer> cardStats;
//        cardStats = new LinkedHashMap<>();
//        cardStats.put("strength", card.getStrength());
//        cardStats.put("intelligence", card.getIntelligence());
//        cardStats.put("agility", card.getAgility());
//        cardStats.put("charisma", card.getCharisma());
//
//        String playForAttribute = cardStats.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();
//        int valueOfPlayAttribute = cardStats.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getValue();
//
//        return playForAttribute;
//    }

    @Override
    public String chooseStatistic() {
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Choose Statistic That You Want To Use:\n (1)strength\n (2)intelligence\n (3)agility\n (4)charisma\n");
            int userInput = Ui.getNumericInput();
            if(userInput == 1){
                return "strength";
            }
            else if(userInput == 2){
                return "intelligence";
            }
            else if(userInput == 3){
                return "agility";
            }
            else if(userInput == 4){
                return "charisma";
            }
            else{
                System.out.println("Choose Only Allowed Option: \n");
                return "lol";
            }
        }   return "lol2";
    }

    public static void playTheGame(){
        Ui.displayMenu();

    }
}