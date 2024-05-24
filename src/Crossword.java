import java.io.FileNotFoundException;
import java.util.*;

public class Crossword {

    //#region Variables/Constructors

    private ArrayList<Square>[] tileGrid;
    private ArrayList<Clue> clueList;
    private int size;

    public Crossword(int size) throws FileNotFoundException {

        this.size = size;
        this.tileGrid = initializeGrid(this.size);
        this.clueList = FileHandler.getClueList(Main.CROSSWORD_DATA);
        updateClueGrid();

    }

    //#endregion

    //#region Methods
    private ArrayList[] initializeGrid(int size) {

        ArrayList[] result = new ArrayList[size];

        for (int i = 0; i < size; i++) {

            ArrayList<Square> row = new ArrayList<>();

            for (int j = 0; j < size; j++) {

                Square initial = new Square();
                row.add(initial);

            }

            result[i] = row;

        }

        return result;

    }

    private void updateClueGrid() {

        clueList.forEach( clue -> {

            //Write it on the grid
            String guess = clue.getGuess();

            int posX = clue.getStartX();
            int posY = clue.getStartY();

            for (int i = 0; i < guess.length(); i++) {

                char next = guess.charAt(i);

                switch (clue.getDirection()) {

                    case "h":
                        tileGrid[posY].get((posX + i)).setLetter(next);
                        break;

                    case "v":
                        tileGrid[posY + i].get(posX).setLetter(next);
                        break;

                    default:
                        System.out.println("Invalid direction");
                        break;
                }

            }
        });

    }

    public void guess(int hintID, String guess) {

        boolean match = false;

        for (int i = 0; i < clueList.size(); i++) {

            Clue clue = clueList.get(i);

            if (clue.getHintID() == hintID) {

                match = true;

                if (!clue.validateGuess(guess)) {

                    printFormat("Guess does not fit in this space");

                    return;
                }

                clue.setGuess(guess);

            }
        }

        if (!match) {
            printFormat("HintID not found!");
        }

    }

    public void checkAnswers() {

        clueList.forEach( clue -> {
            clue.setCorrect(clue.getAnswer().equalsIgnoreCase(clue.getGuess()));
        });

    }

    public void checkScore() {

        StringBuilder result = new StringBuilder();

        int score = 0;

        for (int i = 0; i < clueList.size(); i++) {

            Clue clue = clueList.get(i);

            result.append(clue.printCorrect() + "\n");
            if (clue.isCorrect()) { score++; }
        }

        result.append("\nScore: " + score + "/" + clueList.size());

        printFormat(result.toString());

    }

    public void erase(int hintID) {

        boolean match = false;

        for (int i = 0; i < clueList.size(); i++) {

            Clue clue = clueList.get(i);

            if (clue.getHintID() == hintID) {
                match = true;
                String answer = clue.getAnswer();
                String initial = clue.initialGuess(answer);
                clue.setGuess(initial);

            }
        }

        if (match) {
            printFormat("Hint erased!");

        } else {
            printFormat("HintID not found!");

        }

    }

    //#endregion

    //#region Printers
    public void displayBoard() {

        updateClueGrid();
        
        for (int i = 0; i < tileGrid.length; i++) {

            ArrayList<Square> row = tileGrid[i];

            StringBuilder line = new StringBuilder();

            row.forEach( col -> {

                line.append("|" + col.getLetter());

            });

            line.append("|");

            System.out.println(line);

        }

    }

    public void printHints(int hintID) {

        StringBuilder result = new StringBuilder();

        if (hintID == -1) {

            result.append("All Clues: ");
            clueList.forEach( clue -> result.append("\n" + clue));

        } else {

            result.append("Next Clue: ");
            clueList.forEach( clue -> {

                if (clue.getHintID() == hintID) {
                    result.append("\n" + clue);
                }

            });

        }

        printFormat(result.toString());

    }

    public void printDivider() {

        for (int i = 0; i < (size * 2) + 1; i++) {
            System.out.print("=");
        }
        System.out.println();

    }

    public int getNextClue() {

        int next = -1;

        for (int i = 0; i < clueList.size(); i++) {

            Clue check = clueList.get(i);
            if (!check.isCorrect()) {
                next = check.getHintID();
                break;
            }

        }

        return next;

    }

    public void printFormat(String line) {

            System.out.println();
            printDivider();
            System.out.println(line);
            printDivider();
            System.out.println();

    }

    //#endregion
}

