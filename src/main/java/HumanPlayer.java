public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }


    @Override
    public String chooseStatistic() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Choose Statistic That You Want To Use...");

            int userInput = Ui.getNumericInput();
            if (userInput == 1) {
                return "strength";
            } else if (userInput == 2) {
                return "intelligence";
            } else if (userInput == 3) {
                return "agility";
            } else if (userInput == 4) {
                return "charisma";
            } else {
                System.out.println("Choose Only Allowed Option: \n");
                return "lol";
            }
        }
        return "lol2";
    }
}