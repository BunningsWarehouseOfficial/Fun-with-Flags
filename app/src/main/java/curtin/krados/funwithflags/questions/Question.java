package curtin.krados.funwithflags.questions;

public class Question {
    private final String mQuestionText;
    private int mPoints; //Can be increased by special question reward
    private final int mPenalty;
    private final boolean mIsSpecial;
    private int mCorrectAnswer; //Between 1 and 4; for true/false questions 1 is true and 2 is false
    private final String[] mAnswers;
    private boolean mIsAnswered;

    //Constructor
    public Question(String questionText, int points, int penalty, boolean isSpecial,
                    int correctAnswer, String[] answers) {
        mQuestionText = questionText;
        mPoints = points;
        mPenalty = penalty;
        mIsSpecial = isSpecial;
        mAnswers = answers;
        mIsAnswered = false;

        if (1 <= correctAnswer && correctAnswer <= answers.length) {
            mCorrectAnswer = correctAnswer;
        }
        else {
            throw new IllegalArgumentException("Correct answer is not in range of available answers");
        }
    }

    //Accessors
    public String getQuestionText() {
        return mQuestionText;
    }
    public int getPoints() {
        return mPoints;
    }
    public int getPenalty() {
        return mPenalty;
    }
    public boolean isSpecial() {
        return mIsSpecial;
    }
    public int getCorrectAnswer() {
        return mCorrectAnswer;
    }
    public String[] getAnswers() {
        return mAnswers;
    }
    public boolean isAnswered() {
        return mIsAnswered;
    }

    //Mutator
    public void setPoints(int points) {
        mPoints = points;
    }
    public void setCorrectAnswer(int correctAnswer) {
        mCorrectAnswer = correctAnswer;
    }
    public void setAnswered(boolean answered) {
        mIsAnswered = answered;
    }
}
