
import java.util.*;
import java.io.*;

public class Main {

    public static final File CROSSWORD_DATA = new File(".\\Files\\Clayton Cornell - 3_TextFile.txt");
    public static final Crossword game;
    public static final Scanner userIn = new Scanner(System.in);

    static {
        try {
            game = new Crossword(11);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        do {

            game.displayBoard();
            int option = getOption();

            switch (option) {

                case 0:
                    takeGuess();
                    break;
                case 1:
                    displayAllClues();
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
                    displayAnswers();
                    System.exit(0);
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

        return userIn.nextInt();

    }

    private static void takeGuess() {
    }

    public static void displayAllClues() {

    }

    public static void displayNextClue() {

    }

    public static void eraseGuess() {

    }

    public static void submitPuzzle() {

    }

    private static void displayAnswers() {

    }

}
