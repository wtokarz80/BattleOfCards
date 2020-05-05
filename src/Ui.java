import java.util.Scanner;

public class Ui {

    public void displayMenu(){
        boolean isRunning = true;
        System.out.println("Welcome To Battle Cards\n");
        while(isRunning){
            int choice;
            getInput("Select on of the options:\n(1) Play The Game\n(2)About The Game\n(3)Creators List\n(4)Quit The Game");
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

    public static int getInput(String message){
        int userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();
        return userInput;
    }

    public static void welcomeScreen(){
        clearScreen();
        System.out.println("Welcome To Battle Cards \n");
    }

    public static void winningScreen(){
        clearScreen();
        System.out.println("\n Player 1 wins the game \n");
    }

    public static void loosingScreen(){
        clearScreen();
        System.out.println("\n You loose, computer wins \n");
    }

    public static void creatorsList(){
        System.out.println("This Game Was Created By: \n");
        System.out.println("Mikołaj Urbanek \n");
        System.out.println("Wojciech Tokarz \n");
        System.out.println("Michał Myczka \n");
    }

    public static void exitGame(){
        System.out.println("Bye Bye");
        System.exit(0);
    }

    public static void displayAbout(){
        System.out.println("This Game Is Called Battle Cards\n");
        System.out.println("The Game Takes Place Alternately With Other Players Or A Computer\n");
        System.out.println("When It's Your Turn, Choose Statistic Of Your Current Card That You Want To Use\n");
        System.out.println("Highest Statistic Out Of The Chosen One Wins\n");
        System.out.println("Player Takes All The Other Cards And Put Them At The Bottom Of His Deck\n");
        System.out.println("Game Ends When Any Of The Players Or Computers Runs Out Of Cards To Play\n");
        System.out.println("Player With The Most Amount Of Cards Wins\n");
        System.out.println("Good Luck!\n");
    }
}
