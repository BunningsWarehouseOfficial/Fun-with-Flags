package curtin.krados.funwithflags;

public class Country {
    private final String mName;
    private final int mFlagId;
    private final Question[] mQuestions;

    //Constructor
    public Country(String name, int flagId, Question[] questions) {
        mName = name;
        mFlagId = flagId;
        mQuestions = questions;
    } //TODO constructor with no Question[] parameter?

    //Accessors
    public String getName() {
        return mName;
    }
    public int getFlagId() {
        return mFlagId;
    }
}
