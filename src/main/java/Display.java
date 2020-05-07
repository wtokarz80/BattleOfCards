import com.jakewharton.fliptables.FlipTable;

import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);


    public String displayEmptyCard(){
        String sign = "\u29eb";
        String output = "";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        output += "      " + sign.repeat(15) + "\n";
        return output;
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

    public void displayStartScreen() {
    }

    public void displayStartScreen(Player currentPlayer, Player opponentPlayer) {
        String[] header = {"", "BATTLE OF CARDS", ""};
        String[][] data1 = {{String.format("Current Player: %-11s", currentPlayer.getPlayerName()), "",
        String.format("Opponent player: %-10s", opponentPlayer.getPlayerName())},
                {String.format("Cards in hand: %d", currentPlayer.getHand().getHandList().size()), "",
                        String.format("Cards in hand: %d", opponentPlayer.getHand().getHandList().size())},
                {displayEmptyCard(), "", displayEmptyCard()}};
        System.out.println(FlipTable.of(header, data1));
    }

    public String getStringInput(){
        System.out.println("Press enter to continue...");
        scanner.useDelimiter(System.lineSeparator());
        String userInputString;
        userInputString = scanner.nextLine();
        return userInputString;
    }

    public void currentCard(Player currentPlayer) {
        String[] header = {currentPlayer.showCurrentCard().getName().toUpperCase()};
        String[][] data1 = {{currentPlayer.showCurrentCard().toStringCard()}};
        System.out.println(FlipTable.of(header, data1));
    }
}

