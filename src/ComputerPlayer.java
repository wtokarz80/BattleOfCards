public class ComputerPlayer extends Player {


    public ComputerPlayer(String playerName, Hand hand) {
        super(playerName, hand);
    }


    @Override
    void chooseStatistic() {
        Card card = super.showCurrentCard();


    }
}
