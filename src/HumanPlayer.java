import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, Hand hand) {
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

//    @Override
//    void chooseStatistic() {
//        boolean isRunning = true;
//        while(isRunning){
//            System.out.println("Choose Statistic That You Want To Use:\n (1)strength\n(2)intelligence\n(3)agility\n(4)charisma\n");
//            int userInput = Ui.getNumericInput();
//            if(userInput == 1){
//                isRunning = false;
//            }
//            else if(userInput == 2){
//                isRunning = false;
//            }
//            else if(userInput == 3){
//                isRunning = false;
//            }
//            else if(userInput == 4){
//                isRunning = false;
//            }
//            else{
//                System.out.println("Choose Only Allowed Option: \n");
//            }
//        }
//    }

    public static void playTheGame(){
        Ui.displayMenu();

    }
}