import java.io.FileNotFoundException;
import java.util.*;

public class Crossword {

    //#region Variables/Constructors

    private ArrayList<ArrayList<Square>> tileGrid;
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
    private ArrayList<ArrayList<Square>> initializeGrid(int size) {

        ArrayList<ArrayList<Square>> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            ArrayList<Square> row = new ArrayList<>();

            for (int j = 0; j < size; j++) {

                Square initial = new Square();
                row.add(initial);

            }

            result.add(row);

        }

        return result;

    }

    private void generateClueGrid() {

        clueList.forEach( clue -> {
            //Write it on the grid
            String answer = clue.getAnswer();

            int posX = clue.getStartX();
            int poxY = clue.getStartY();

            for (int i = 0; i < answer.length(); i++) {

                char newChar;

                if (i == 0) {
                    newChar = (char) clue.getHintID();
                }
                else {
                    newChar = '.';
                }

                

            }
        });

    }

    //#endregion

    //#region Printers
    public void displayBoard() {
    }

    //#endregion
}

