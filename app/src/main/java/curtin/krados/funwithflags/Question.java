package curtin.krados.funwithflags;

public class Question {
    private final String mQuestionText;
    private int mPoints; //Can be increased by special question reward
    private final int mPenalty;
    private final boolean mIsSpecial;
    private boolean mIsAnswered;

    //Constructor
    public Question(String questionText, int points, int penalty, boolean isSpecial) {
        mQuestionText = questionText;
        mPoints = points;
        mPenalty = penalty;
        mIsSpecial = isSpecial;
        mIsAnswered = false;
    }
}
