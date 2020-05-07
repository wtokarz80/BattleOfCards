import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;

import java.util.MissingFormatWidthException;
import java.util.Scanner;

public class Ui {

    public void displayMenu(){
        clearScreen();
        String[] headers = {"", "Select one of the options:"};
        String[][] data = {{ "(1)", "Play The Game" },
        { "(2)", "About The Game" },
        { "(3)", "Creators List" },
        { "(0)", "Quit The Game" }
        };
        boolean isRunning = true;
        welcomeScreen();
        while(isRunning){
            System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
            int userInput = getNumericInput();
            if(userInput == 1){
                clearScreen();
                chooseGameMode();
                isRunning = false;
            }
            else if(userInput == 2){
                clearScreen();
                displayAbout();
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
                clearScreen();
            }
            else if(userInput == 3){
                clearScreen();
                creatorsList();
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
                clearScreen();
            }
            else if(userInput == 0){
                exitGame();
            }
            else{
                clearScreen();
                System.out.println(Chalk.on("Please Choose Only Allowed Options").red());
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
                clearScreen();
            }
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }


    public static int getNumericInput(){
        int userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();
        return userInput;
    }

    public static String getStringInput(){
        String userInputString;
        Scanner scanner = new Scanner(System.in);
        userInputString = scanner.nextLine();
        return userInputString;
    }


    public void welcomeScreen(){
        clearScreen();
        String header[] = {"Welcome To Battle Cards"};
        String data[][] = {{"MAIN MENU: "}};
        System.out.println(Chalk.on(FlipTable.of(header, data)).cyan());
    }


    public void creatorsList(){
        String[] headers = {"This Game Was Created By:"};
        String[][] data = { { "Mikołaj Urbanek" },
        { "Wojciech Tokarz" },
        { "Michał Myczka" } };
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
    }

    public void exitGame(){
        clearScreen();
        String[] headers = {"The Game Will End Now"};
        String[][] data = { { "Bye Bye" }};
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
        System.exit(0);
    }

    public void displayAbout(){
        String[] headers = {"Rules Of The Game:"};
        String[][] data = { {"This Game Is Called Battle Cards" },
                {"The Game Takes Place Alternately With Other Players Or A Computer" },
                {"When It's Your Turn, Choose Statistic Of Your Current Card That You Want To Use" },
                { "Highest Statistic Out Of The Chosen One Wins"},
                {"Player Takes All The Other Cards And Put Them At The Bottom Of His Deck"},
                {"Game Ends When Any Of The Players Or Computers Runs Out Of Cards To Play"},
                {"Player With The Most Amount Of Cards Wins"},
                {"Good Luck!"} };
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
    }

    public static Player createPlayer(boolean isHuman) {

        Hand hand = new Hand();
        if (isHuman){
            System.out.println(Chalk.on("Enter Your name, please").magenta());
            String playerName = getStringInput();

            return new HumanPlayer(playerName, hand);}
            else
                {return new ComputerPlayer("computer", hand);}
    }

    public void chooseGameMode(){
        boolean isRunning = true;
        while(isRunning){
        clearScreen();
        String[] headers = {"", "Select Game Mode: "};
        String[][] data = {
                {"(1)", "Player vs Computer"},
                {"(2)", "Player vs Player"},
                {"(3)", "Computer vs Computer"}
        };
        System.out.println(Chalk.on(FlipTable.of(headers, data)).cyan());
        int userInput = getNumericInput();

            if(userInput == 1){
                Table table = new Table(true, false);
                isRunning = false;
            }
            else if(userInput == 2){
                Table table = new Table(true, true);
                isRunning = false;
            }
            else if(userInput == 3){
                Table table = new Table(false, false);
                isRunning = false;
            }
            else{
                System.out.println(Chalk.on("Please Choose Only Allowed Options").red());
                System.out.println(Chalk.on("Press Enter To Continue").magenta());
                getStringInput();
            }
        }
    }
}
