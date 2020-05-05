public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }

    @Override
    void chooseStatistic() {
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Choose Statistic That You Want To Use:\n (1)strength\n(2)intelligence\n(3)agility\n(4)charisma\n");
            int userInput = Ui.getNumericInput();
            if(userInput == 1){
                isRunning = false;
            }
            else if(userInput == 2){
                isRunning = false;
            }
            else if(userInput == 3){
                isRunning = false;
            }
            else if(userInput == 4){
                isRunning = false;
            }
            else{
                System.out.println("Choose Only Allowed Option: \n");
            }
        }
    }

    public static void playTheGame(){
        Ui.displayMenu();

    }
}