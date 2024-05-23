import java.util.*;
import java.io.*;

public class FileHandler {

    public static final String DELIMITER = ":";

    public static ArrayList<Clue> getClueList(File input)
        throws FileNotFoundException {

        ArrayList<Clue> result = new ArrayList<>();

        Scanner fReader = new Scanner(input);

        while (fReader.hasNextLine()) {

            String[] splitLine = fReader.nextLine().split(DELIMITER);

            if (splitLine.length < 6) {
                System.out.println(
                    "Err: Reference File missing data!" +
                    "\nFilepath: " + Main.CROSSWORD_DATA.getPath()
                );
                System.exit(1);
                return null;
            }

            //#region Critical Issue

            /*
            for (int i = 0; i < splitLine.length; i++) {
                System.out.println(splitLine[i]);
            }

             */

            // === Issue ===
            //
            // splitLine is a String Array
            // splitLine[i] returns a string
            //
            // splitLine[i] is not a valid parameter for
            // Integer.parseInt or Integer.valueOf

            /*
            int startX = Integer.parseUnsignedInt(splitLine[0]);
            int startY = Integer.parseInt(splitLine[1]);
            String direction = splitLine[2];
            int hintID = Integer.parseInt(splitLine[3]);
            String hint = splitLine[4];
            String answer = splitLine[5];
             */

            // Will plug in values once issue is solved
            Clue nextClue = new Clue(0, 0, "h", 0, "hint", "answer");

            result.add(nextClue);

            //#endregion

        }

        fReader.close();

        return result;

    }

}
