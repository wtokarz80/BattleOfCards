import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;

import java.util.Scanner;

public class Ui {

    Scanner scanner = new Scanner(System.in);
    Display display = new Display();

    public void choseOptionFromMainMenu() {
        clearScreen();
        display.welcomeScreen();
        while (true) {
            display.displayMainMenu();
            int userInput = getNumericInput("", 0, 4);
            if (userInput == 1) {
                clearScreen();
                chooseGameMode();
                choseOptionFromMainMenu();
            } else if (userInput == 2) {
                clearScreen();
                display.displayAbout();
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
                clearScreen();
            } else if (userInput == 3) {
                clearScreen();
                display.creatorsList();
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
                clearScreen();
            } else if (userInput == 0) {
                exitGame();
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public String getStringInput() {
        String userInputString;
        Scanner scanner = new Scanner(System.in);
        userInputString = scanner.nextLine();
        return userInputString;
    }

    public int getNumericInput(String title, int from, int to) {
        scanner.useDelimiter(System.lineSeparator());
        String userInput = "";
//        System.out.print(title);
        boolean validInput = false;
        while (!validInput) {
            userInput = scanner.next();
            if (isNumericValue(userInput) && isNumberInRange(userInput, from, to)) {
                validInput = true;
            }
        }
        return Integer.parseInt(userInput);
    }

    private static boolean isNumericValue(String userInput) {
        return !userInput.equals("") && userInput.matches("^[0-9]*$");
    }

    private boolean isNumberInRange(String userInput, int from, int to) {
        int option = Integer.parseInt(userInput);
        return option >= from && option < to;
    }

    public void exitGame() {
        clearScreen();
        String[] headers = {"The Game Will End Now"};
        String[][] data = {{"Bye Bye"}};
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
        System.exit(0);
    }

    public void chooseGameMode() {
        boolean isRunning = true;
        display.displayGameMode();
        while (isRunning) {
            clearScreen();
            int userInput = getNumericInput("", 1, 4);
            clearScreen();
            if (userInput == 1) {
                Table table = new Table(true, false);
                isRunning = false;
            } else if (userInput == 2) {
                Table table = new Table(true, true);
                isRunning = false;
            } else if (userInput == 3) {
                Table table = new Table(false, false);
                isRunning = false;
            }
        }
    }
}
