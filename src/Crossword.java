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
        generateClueGrid();

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

    private void generateClueGrid() {

        clueList.forEach( clue -> {

            //Write it on the grid
            String answer = clue.getAnswer();

            int posX = clue.getStartX();
            int posY = clue.getStartY();

            for (int i = 0; i < answer.length(); i++) {

                char newChar;

                if (i == 0) {
                    newChar = String.valueOf(clue.getHintID()).charAt(0);
                }
                else {
                    newChar = '.';
                }

                switch (clue.getDirection()) {

                    case "h":
                        tileGrid[posY].get((posX + i)).setLetter(newChar);
                        break;

                    case "v":
                        tileGrid[posY + i].get(posX).setLetter(newChar);
                        break;

                    default:
                        System.out.println("Invalid direction");
                        break;
                }

            }
        });

    }

    //#endregion

    //#region Printers
    public void displayBoard() {

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

        if (hintID == -1) {

            clueList.forEach( clue -> {
                System.out.println(clue);
            });
            return;
        }

        System.out.println(clueList.get(hintID));

    }

    //#endregion
}

