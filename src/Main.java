
import java.util.*;
import java.io.*;

public class Main {

    public static final File CROSSWORD_DATA = new File(".\\Files\\ClueList.txt");
    public static final Crossword game;
    public static final Scanner userIn = new Scanner(System.in);

    static {
        try {
            game = new Crossword(12);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        do {

            game.displayBoard();
            int option = getOption();

            switch (option) {

                case 0:
                    takeGuess();
                    break;
                case 1:
                    game.printHints(-1);
                    break;
                case 2:
                    displayNextClue();
                    break;
                case 3:
                    eraseGuess();
                    break;
                case 4:
                    submitPuzzle();
                    break;
                case 5:
                    submitPuzzle();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nPlease a valid option");
                    System.out.println();
                    break;

            }

        } while (true);

    }

    private static int getOption() {

        System.out.println(
                "\nGame Options" +
                "\n0. Take Guess" +
                "\n1. Display All Clues" +
                "\n2. Display Next Clue" +
                "\n3. Erase Guess" +
                "\n4. Submit Puzzle" +
                "\n5. Exit"
        );

        int option = 0;

        try {
            option = userIn.nextInt();

        } catch (InputMismatchException err) {
            System.out.println("\nPlease enter an integer to select an option");
            System.exit(1);

        }

        return option;

    }

    private static void takeGuess() {

        System.out.println();
        System.out.println(
                "Enter HintID you would like to answer"
        );

        int hintID = userIn.nextInt();
        userIn.nextLine();

        System.out.println(
                "What would you like to write?"
        );

        String guess = userIn.nextLine();

        game.guess(hintID, guess);
        game.checkAnswers();

        System.out.println();

    }

    public static void displayNextClue() {

        int next = game.getNextClue();

        if (next != -1) {

            game.printHints(next);

        } else {

            game.printFormat("You have no more clues!");

        }

    }

    public static void eraseGuess() {

        System.out.println();
        System.out.println(
                "Enter HintID you would like to erase"
        );

        int hintID = userIn.nextInt();
        userIn.nextLine();

        game.erase(hintID);

    }

    public static void submitPuzzle() {

        game.checkScore();

    }

    private static void displayAnswers() {

    }

}
