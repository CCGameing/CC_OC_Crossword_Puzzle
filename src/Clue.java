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
            int startX, int startY,
            String direction,
            int hintID, String hint,
            String answer
    ) {
        this.startX = startX;
        this.startY = startY;
        this.direction = direction;
        this.hintID = hintID;
        this.hint = hint;
        this.answer = answer;
    }

    //#endregion

    //#region Methods
    public boolean validateGuess(String newGuess) {

        if (newGuess.length() > answer.length()) {
            return false;
        }
        return true;

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

    //#endregion

    //#region Printers
    @Override
    public String toString() {
        return hintID + ". " + hint;
    }

    public String printAnswer() {
        return hintID + ". " + answer + " (" + hint + ")";
    }

    //#endregion

}
