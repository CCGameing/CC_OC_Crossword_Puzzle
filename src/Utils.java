public class Utils {

    public static String toLength(String line, char fill, int length) {

        //Make a copy
        StringBuilder result = new StringBuilder(line.toString());

        while (result.length() < length) {
            result.append(fill);
        }

        return result.toString();

    }

    public static String listToLength(String[] lines, char fill, int[] lengths) {

        String result = lines[0];

        for (int i = 1; i < lines.length; i++) {

            result = toLength(result, fill, lengths[i - 1]);
            result += lines[i];

        }

        return result;

    }

}
