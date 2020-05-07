import java.util.*;

public class Table {
    Display display;
    Scanner scan;
    private List<Card> tableCards;
    XMLParser xmlParser;
    Deck newDeck;
    Player player1;
    Player player2;

    public Table(boolean isHuman1, boolean isHuman2) {
        display = new Display();
        scan = new Scanner(System.in);
        player1 = Ui.createPlayer(isHuman1);
        player2 = Ui.createPlayer(isHuman2);
        xmlParser = new XMLParser();
        newDeck = xmlParser.getDeck();
        tableCards = new ArrayList<>();                  //krupier wyciąga karty na stół

        newDeck.shuffle();
        display.clearScreen();

        setPlayersHands(player1, player2, 3);


        initializeGame();
    }

    public void initializeGame(){
        boolean ifCanPlay = true;
        boolean switchPlayer = false;
        Player currentPlayer = player1;
        Player opponentPlayer = player2;
        display.displayStartScreen(currentPlayer, opponentPlayer);
        display.getStringInput();
        
        while(ifCanPlay){
            if(!switchPlayer){
                switchPlayer = true;
                currentPlayer = player1;
                opponentPlayer = player2;    
            } else {
                switchPlayer = false;
                currentPlayer = player2;
                opponentPlayer = player1;
            }
            startGame(currentPlayer, opponentPlayer);
            ifCanPlay = canPlayersPlayer(currentPlayer, opponentPlayer);
        }
        endGameScreen(currentPlayer, opponentPlayer);
    }

    private void endGameScreen(Player currentPlayer, Player opponentPlayer) {
        String winner;
        String loser;
        if (currentPlayer.getHand().getHandList().size() != 0){
            winner = currentPlayer.getPlayerName();
            loser = opponentPlayer.getPlayerName();
        } else {
            winner = opponentPlayer.getPlayerName();
            loser = currentPlayer.getPlayerName();
        }
        System.out.println("The Winner is: " + winner);
        System.out.println("The Looser is: " + loser);
    }

    private boolean canPlayersPlayer(Player currentPlayer, Player opponentPlayer) {
        int player1Cards = player1.getHand().getHandList().size();
        int player2Cards = player2.getHand().getHandList().size();
        return (player1Cards > 0 && player2Cards > 0);
    }

    private void startGame(Player currentPlayer, Player opponentPlayer) {

        Card currentPlayerCard = currentPlayer.showCurrentCard();
        Card opponentPlayerCard = opponentPlayer.showCurrentCard();
        System.out.println("Your card: \n");
        display.currentCard(currentPlayer);
//        System.out.println(currentPlayer.getPlayerName() + "'s " + currentPlayerCard.toString());
        String chosenStatistic = currentPlayer.chooseStatistic();

        playerPutCard(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard, chosenStatistic);

        switch (chosenStatistic) {
            case "strength":
                checkStrength(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard);
                break;
            case "intelligence":
                checkIntelligence(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard);
                break;
            case "agility":
                checkAgility(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard);
                break;
            case "charisma":
                checkCharisma(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard);
                break;
        }

        System.out.println(currentPlayer.getPlayerName() + " hand size :" + currentPlayer.getHand().getHandList().size());
        System.out.println(opponentPlayer.getPlayerName() + " hand size:" + opponentPlayer.getHand().getHandList().size());
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    private void checkCharisma(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard) {
        if (currentPlayerCard.getCharisma() > opponentPlayerCard.getCharisma()){
            for (Card card : tableCards){
                currentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(currentPlayer.getPlayerName() + " wins, and takes both cards");
        } else if (currentPlayerCard.getCharisma() < opponentPlayerCard.getCharisma()){
            for (Card card : tableCards){
                opponentPlayer.getHand().getHandList().add(card);
            }
            Common.delay(2000);
            System.out.println(opponentPlayer.getPlayerName() + " wins, and takes both cards");
            tableCards.clear();
        }
    }

    private void checkAgility(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard) {
        if (currentPlayerCard.getAgility() > opponentPlayerCard.getAgility()){
            for (Card card : tableCards){
                currentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(currentPlayer.getPlayerName() + " wins, and takes both cards");
        } else {
            for (Card card : tableCards){
                opponentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(opponentPlayer.getPlayerName() + " wins, and takes both cards");
        }
    }

    private void checkIntelligence(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard) {
        if (currentPlayerCard.getIntelligence() > opponentPlayerCard.getIntelligence()){
            for (Card card : tableCards){
                currentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(currentPlayer.getPlayerName() + " wins, and takes both cards");
        } else {
            for (Card card : tableCards){
                opponentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(opponentPlayer.getPlayerName() + " wins, and takes both cards");
        }
    }

    private void checkStrength(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard) {
        if (currentPlayerCard.getStrength() > opponentPlayerCard.getStrength()){
            for (Card card : tableCards){
                currentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(currentPlayer.getPlayerName() + " wins, and takes both cards");
        } else {
            for (Card card : tableCards){
                opponentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            Common.delay(2000);
            System.out.println(opponentPlayer.getPlayerName() + " wins, and takes both cards");
        }
    }

    private void playerPutCard(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard, String chosenStatistic) {
   //     System.out.println("Table size: " + tableCards.size());

        System.out.println();

        System.out.println(currentPlayer.getPlayerName() + " has chosen " + chosenStatistic);
        Common.delay(1000);

        tableCards.add(currentPlayerCard);
        currentPlayer.removeCard(currentPlayerCard);

        tableCards.add(opponentPlayerCard);
        opponentPlayer.removeCard(opponentPlayerCard);

        System.out.println(currentPlayer.getPlayerName() + "'s " + currentPlayerCard);
        System.out.println(opponentPlayer.getPlayerName() + "'s " + opponentPlayerCard);



    }


    public void setPlayersHands(Player player1, Player player2, int numberOfCards){
        if (numberOfCards > newDeck.getCardList().size() || numberOfCards <= 0){
            numberOfCards = newDeck.getCardList().size();
        }
        Hand player1Hand = new Hand();                                              //gracze wyciagają ręce
        Hand player2Hand = new Hand();

        for(int s = 0; s < numberOfCards; s++) {                                    //krupier rozdaje karty raz jednemu raz drugiemu
            dealOneCard(newDeck, player1Hand);
            dealOneCard(newDeck, player2Hand);
        }
        player1.setHand(player1Hand);
        player2.setHand(player2Hand);
    }

    public Hand dealOneCard(Deck deck, Hand hand){
        hand.addCard(deck.getCardByIndex(0));
        deck.removeCard(0);
        return hand;
    }

}