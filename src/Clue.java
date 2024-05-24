public class Clue {

    //#region Variables/Constructors

    private int startX;
    private int startY;
    private String direction;
    private int hintID;
    private String hint;
    private String answer;
    private String guess;
    private boolean isCorrect;

    public Clue(
            int startY, int startX,
            String direction,
            int hintID, String answer,
            String hint
    ) {
        this.startX = startX;
        this.startY = startY;
        this.direction = direction;
        this.hintID = hintID;
        this.hint = hint;
        this.answer = answer;
        this.isCorrect = false;
        this.guess = initialGuess(answer);
    }

    //#endregion

    //#region Methods
    public boolean validateGuess(String newGuess) {

        if (newGuess.length() != answer.length()) {
            return false;
        }
        return true;

    }

    public String initialGuess(String answer) {

        StringBuilder result = new StringBuilder();

        result.append(hintID);

        for (int i = 1; i < answer.length(); i++) {
            result.append(".");
        }

        return result.toString();

    }

    //#endregion

    //#region Getters/Setters
    public String getAnswer() {
        return answer;
    }

    public int getHintID() {
        return hintID;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setCorrect(boolean b) {
        isCorrect = b;
    }

    //#endregion

    //#region Printers
    @Override
    public String toString() {
        return hintID + ". " + hint +
        "\n" + "Current Guess: " + guess;
    }

    public String printAnswer() {
        return hintID + ". " + answer + " (" + hint + ")";
    }

    public String printCorrect() {

        String result = Utils.listToLength(
                new String[]{hintID + ". ", guess, "=", String.valueOf(isCorrect)},
                ' ',
                new int[]{4, 16, 20}
        );

        return result;
    }

    //#endregion

}
