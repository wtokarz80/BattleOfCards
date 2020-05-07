import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;

import java.util.List;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);


    public String displayEmptyCard() {
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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void displayStartScreen(Player currentPlayer, Player opponentPlayer, List<Card> tableCards) {
        String[] header = {"", "BATTLE OF CARDS", ""};
        String[][] data1 = {{String.format("Current Player: %-11s", currentPlayer.getPlayerName()), "",
                String.format("Opponent player: %-10s", opponentPlayer.getPlayerName())},
                {String.format("Cards in hand: %d", currentPlayer.getHand().getHandList().size()), String.format("Cards on table: %d", tableCards.size()),
                        String.format("Cards in hand: %d", opponentPlayer.getHand().getHandList().size())},
                {displayEmptyCard(), "", displayEmptyCard()}};
        System.out.println(Chalk.on(FlipTable.of(header, data1)).cyan());
    }

    public void welcomeScreen() {
        String header[] = {"Welcome To Battle Cards"};
        String data[][] = {{"MAIN MENU: "}};
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
}

