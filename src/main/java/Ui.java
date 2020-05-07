import com.jakewharton.fliptables.FlipTable;

import java.util.Scanner;

public class Ui {

    public void displayMenu(){
        String[] headers = {"","Select one of the options:"};
        String[][] data = {{ "(1)", "Play The Game" },
        { "(2)", "About The Game" },
        { "(3)", "Creators List" },
        { "(0)", "Quit The Game" }
        };
        boolean isRunning = true;
        welcomeScreen();
        while(isRunning){
            System.out.println(FlipTable.of(headers, data));
            int userInput = getNumericInput();
            if(userInput == 1){
                chooseGameMode();
                isRunning = false;
            }
            else if(userInput == 2){
                clearScreen();
                displayAbout();
                System.out.println("Press Enter To Continue\n");
                getStringInput();
            }
            else if(userInput == 3){
                clearScreen();
                creatorsList();
                System.out.println("Press Enter To Continue\n");
                getStringInput();
            }
            else if(userInput == 0){
                exitGame();
            }
            else{
                clearScreen();
                System.out.println("Please Choose One Of The Available Options: \n");
                System.out.println("Press Enter To Continue\n");
                getStringInput();
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
        System.out.println("Welcome To Battle Cards \n");
    }


    public void creatorsList(){
        System.out.println("This Game Was Created By: \n");
        System.out.println("Mikołaj Urbanek \n");
        System.out.println("Wojciech Tokarz \n");
        System.out.println("Michał Myczka \n");
    }

    public void exitGame(){
        System.out.println("Bye Bye");
        System.exit(0);
    }

    public void displayAbout(){
        System.out.println("This Game Is Called Battle Cards\n");
        System.out.println("The Game Takes Place Alternately With Other Players Or A Computer\n");
        System.out.println("When It's Your Turn, Choose Statistic Of Your Current Card That You Want To Use\n");
        System.out.println("Highest Statistic Out Of The Chosen One Wins\n");
        System.out.println("Player Takes All The Other Cards And Put Them At The Bottom Of His Deck\n");
        System.out.println("Game Ends When Any Of The Players Or Computers Runs Out Of Cards To Play\n");
        System.out.println("Player With The Most Amount Of Cards Wins\n");
        System.out.println("Good Luck!\n");
    }

    public static Player createPlayer(boolean isHuman) {

        Hand hand = new Hand();
        if (isHuman){
            System.out.println("Enter Your name, please");
            String playerName = getStringInput();

            return new HumanPlayer(playerName, hand);}
            else
                {return new ComputerPlayer("computer", hand);}
    }

    public void chooseGameMode(){
        String[] headers = {"", "Select Game Mode: "};
        String[][] data = {
                {"(1)", "Player vs Computer"},
                {"(2)", "Player vs Player"},
                {"(3)", "Computer vs Computer"}
        };
        System.out.println(FlipTable.of(headers, data));
        int userInput = getNumericInput();
        if(userInput == 1){
            Table table = new Table(true, false);
        }
        else if(userInput == 2){
            Table table = new Table(true, true);
        }
        else if(userInput == 3){
            Table table = new Table(false, false);
        }
        else{
            System.out.println("Use Only Allowed Options");
        }
    }
}
