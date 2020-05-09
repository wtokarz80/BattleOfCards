import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;

import java.util.List;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);


    public String displayEmptyCard() {
        String sign = "\u29eb";
        String output = "";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";
        output += "     " + sign.repeat(22) + "     "  + "\n";

        return output;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void displayStartScreen(Player currentPlayer, Player opponentPlayer, List<Card> tableCards) {
        String[] header = {"", "BATTLE OF CARDS", ""};
        String[][] data1 = {{String.format("Current player: %-11s", currentPlayer.getPlayerName()), "",
                String.format("Opponent player: %-10s", opponentPlayer.getPlayerName())},
                {String.format("Cards in hand: %d", currentPlayer.getHand().getHandList().size()), String.format("Cards on table: %d", tableCards.size()),
                        String.format("Cards in hand: %d", opponentPlayer.getHand().getHandList().size())},
                {displayEmptyCard(), "", displayEmptyCard()}};
        System.out.println(Chalk.on(FlipTable.of(header, data1)).cyan());
    }

    public void welcomeScreen() {
        String header[] = {"     B-A-T-T-L-E"};
        String data[][] = {{"   O F  C A R D S   "}};
        System.out.println(Chalk.on(FlipTable.of(header, data)).cyan());
    }

    public void creatorsList() {
        String[] headers = {"This Game Was Created By:"};
        String[][] data = {{"Mikołaj Urbanek"},
                {"Wojciech Tokarz"},
                {"Michał Myczka"}};
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
    }

    public void displayAbout() {
        String[] headers = {"Rules Of The Game:"};
        String[][] data = {{"This Game Is Called Battle Cards"},
                {"The Game Takes Place Alternately With Other Players Or A Computer"},
                {"When It's Your Turn, Choose Statistic Of Your Current Card That You Want To Use"},
                {"Highest Statistic Out Of The Chosen One Wins"},
                {"Player Takes All The Other Cards And Put Them At The Bottom Of His Deck"},
                {"Game Ends When Any Of The Players Or Computers Runs Out Of Cards To Play"},
                {"Player With The Most Amount Of Cards Wins"},
                {"Good Luck!"}};
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
    }

    public void printTable(Player currentPlayer, Player opponentPlayer, Card currentPlayerCard, Card opponentPlayerCard, String chosenStatistic, List<Card> tableCards) {
        System.out.print("\033[H\033[2J");
        String[] innerHeaders = {"Battle card: "};
        String[][] innerData = {{String.valueOf(currentPlayerCard)}};
        String inner = FlipTable.of(innerHeaders, innerData);
        String[] innerHeaders2 = {"Battle card: "};
        String[][] innerData2 = {{String.valueOf(opponentPlayerCard)}};
        String inner2 = FlipTable.of(innerHeaders2, innerData2);
        String[] headers = {" ", "BATTLE OF CARDS", " "};
        String[][] data = {
                {"Current player: " + currentPlayer.getPlayerName(), " ", "Opponent player: " + opponentPlayer.getPlayerName()},
                {"Cards in hand: " + String.valueOf(currentPlayer.getHand().getHandList().size()), "Cards on table: " + tableCards.size(), "Cards in hand: " + String.valueOf(opponentPlayer.getHand().getHandList().size())},
                {inner, "Comparing by: \n\n" + chosenStatistic.toUpperCase(), inner2}
        };
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
    }

    public void endGameScreen(Player currentPlayer, Player opponentPlayer) {
        String winner;
        String loser;
        if (currentPlayer.getHand().getHandList().size() != 0) {
            winner = currentPlayer.getPlayerName();
            loser = opponentPlayer.getPlayerName();
        } else {
            winner = opponentPlayer.getPlayerName();
            loser = currentPlayer.getPlayerName();
        }
        System.out.println(Chalk.on("\nThe Winner is: " + winner).green());
        System.out.println(Chalk.on("\nThe Looser is: " + loser).red());
        System.out.println("\n\nPress enter to back to main menu.");
        scanner.nextLine();
    }

    public void displayMainMenu(){
        String[] headers = {"", "MAIN MENU"};
        String[][] data = {{"(1)", "Play The Game"},
                {"(2)", "About The Game"},
                {"(3)", "Creators List"},
                {"(0)", "Quit The Game"}
        };
        System.out.print(Chalk.on(FlipTable.of(headers, data)).cyan());
        System.out.print(Chalk.on("Choose Option: ").magenta());
    }

    public void displayGameMode(){
        String[] headers = {"", "Select Game Mode: "};
        String[][] data = {
                {"(1)", "Player vs Computer"},
                {"(2)", "Player vs Player"},
                {"(3)", "Computer vs Computer"}
        };
        System.out.print(Chalk.on(FlipTable.of(headers, data)).cyan());
        System.out.print(Chalk.on("Choose Option: ").magenta());
    }
}

