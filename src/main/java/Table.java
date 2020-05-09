import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;

import java.util.*;

public class Table {
    Ui ui = new Ui();
    Display display = new Display();
    Scanner scan = new Scanner(System.in);
    XMLParser xmlParser = new XMLParser();
    Deck newDeck = xmlParser.getDeck();
    private List<Card> tableCards = new ArrayList<>();
    Player player1;
    Player player2;
    public int count = 0;

    public Table(boolean isHuman1, boolean isHuman2) {
        player1 = createPlayer(isHuman1);
        player2 = createPlayer(isHuman2);

        display.clearScreen();
        newDeck.shuffle();
        display.clearScreen();

        setPlayersHands(3);
        initializeGame();
    }

    public Player createPlayer(boolean isHuman) {

        Hand hand = new Hand();
        if (isHuman) {
            System.out.print(Chalk.on("Enter Your name, please: ").magenta());
            String playerName = ui.getStringInput();
            return new HumanPlayer(playerName, hand);
        } else {
            count = setCount();
            return new ComputerPlayer("computer " + count, hand);

        }
    }

    private int setCount() {
        return count = count + 1;
    }


    public void initializeGame() {
        boolean ifCanPlay = true;
        boolean switchPlayer = false;
        Player currentPlayer = player1;
        Player opponentPlayer = player2;
        display.displayStartScreen(currentPlayer, opponentPlayer, tableCards);
        System.out.println("Press enter to continue...");
        ui.getStringInput();

        while (ifCanPlay) {
            display.clearScreen();
            if (!switchPlayer) {
                switchPlayer = true;
                currentPlayer = player1;
                opponentPlayer = player2;
            } else {
                switchPlayer = false;
                currentPlayer = player2;
                opponentPlayer = player1;
            }
            startGame(currentPlayer, opponentPlayer);
            ifCanPlay = canPlayersPlay(currentPlayer, opponentPlayer);
        }

        display.endGameScreen(currentPlayer, opponentPlayer);
    }

    private boolean canPlayersPlay(Player currentPlayer, Player opponentPlayer) {
        int player1Cards = player1.getHand().getHandList().size();
        int player2Cards = player2.getHand().getHandList().size();
        return (player1Cards > 0 && player2Cards > 0);
    }

    private void startGame(Player currentPlayer, Player opponentPlayer) {

        Card currentPlayerCard = currentPlayer.showCurrentCard();
        Card opponentPlayerCard = opponentPlayer.showCurrentCard();

        System.out.println(currentPlayer.getPlayerName() + "'s Card: \n" + currentPlayerCard.toString());

        String chosenStatistic = currentPlayer.chooseStatistic();
        playerPutCard(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard, chosenStatistic);
        display.printTable(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard, chosenStatistic, tableCards);

        switchAttribute(currentPlayer, opponentPlayer, currentPlayerCard, opponentPlayerCard, chosenStatistic);

        System.out.println("Press enter to deal cards to winner...");
        scan.nextLine();
        display.clearScreen();
        display.displayStartScreen(currentPlayer, opponentPlayer, tableCards);
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    private void switchAttribute(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard, String chosenStatistic) {
        switch (chosenStatistic) {
            case "strength":
                int currentPlayerStat = currentPlayerCard.getStrength();
                int opponentPlayerStat = opponentPlayerCard.getStrength();
                checkAttribute(currentPlayer, opponentPlayer, currentPlayer, opponentPlayer, currentPlayerStat,opponentPlayerStat);
                break;
            case "intelligence":
                currentPlayerStat = currentPlayerCard.getIntelligence();
                opponentPlayerStat = opponentPlayerCard.getIntelligence();
                checkAttribute(currentPlayer, opponentPlayer, currentPlayer, opponentPlayer, currentPlayerStat,opponentPlayerStat);
                break;
            case "agility":
                currentPlayerStat = currentPlayerCard.getAgility();
                opponentPlayerStat = opponentPlayerCard.getAgility();
                checkAttribute(currentPlayer, opponentPlayer, currentPlayer, opponentPlayer, currentPlayerStat,opponentPlayerStat);
                break;
            case "charisma":
                currentPlayerStat = currentPlayerCard.getCharisma();
                opponentPlayerStat = opponentPlayerCard.getCharisma();
                checkAttribute(currentPlayer, opponentPlayer, currentPlayer, opponentPlayer, currentPlayerStat,opponentPlayerStat);
                break;
        }
    }

    private void checkAttribute(Player currentPlayer, Player opponentPlayer, Player currentPlayer1, Player opponentPlayer1, int currentPlayerStat, int opponentPlayerStat) {
        if (currentPlayerStat > opponentPlayerStat){
            for (Card card : tableCards) {
                currentPlayer.getHand().getHandList().add(card);
            }
            tableCards.clear();
            System.out.println(currentPlayer.getPlayerName() + " wins round, and takes cards\n");
        } else if (currentPlayerStat < opponentPlayerStat) {
            for (Card card : tableCards) {
                opponentPlayer.getHand().getHandList().add(card);
            }
            System.out.println(opponentPlayer.getPlayerName() + " wins round, and takes cards\n");
            tableCards.clear();
        }
    }

    private void playerPutCard(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard, String chosenStatistic) {

        tableCards.add(currentPlayerCard);
        currentPlayer.removeCard(currentPlayerCard);
        tableCards.add(opponentPlayerCard);
        opponentPlayer.removeCard(opponentPlayerCard);
    }

    public void setPlayersHands(int numberOfCards) {
        if (numberOfCards > newDeck.getCardList().size() || numberOfCards <= 0) {
            numberOfCards = newDeck.getCardList().size();
        }
        Hand player1Hand = new Hand();                                              //gracze wyciagają ręce
        Hand player2Hand = new Hand();

        for (int s = 0; s < numberOfCards; s++) {                                    //krupier rozdaje karty raz jednemu raz drugiemu
            dealOneCard(newDeck, player1Hand);
            dealOneCard(newDeck, player2Hand);
        }
        player1.setHand(player1Hand);
        player2.setHand(player2Hand);
    }

    public Hand dealOneCard(Deck deck, Hand hand) {
        hand.addCard(deck.getCardByIndex(0));
        deck.removeCard(0);
        return hand;
    }
}