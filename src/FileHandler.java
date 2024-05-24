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

            int startX = Integer.parseUnsignedInt(splitLine[0]);
            int startY = Integer.parseInt(splitLine[1]);
            String direction = splitLine[2];
            int hintID = Integer.parseInt(splitLine[3]);
            String hint = splitLine[4];
            String answer = splitLine[5];

            Clue nextClue = new Clue(startX, startY, direction, hintID, hint, answer);

            result.add(nextClue);

        }

        result.sort(Comparator.comparingInt(clue -> clue.getHintID()));

        fReader.close();

        return result;

    }

}
