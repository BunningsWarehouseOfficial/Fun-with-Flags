package curtin.krados.funwithflags;

import androidx.annotation.NonNull;

import java.util.List;

import curtin.krados.funwithflags.questions.Question;

public class Country {
    private final String mName;
    private final int mFlagId;
    private final List<Question> mQuestions;

    //Constructor
    public Country(String name, int flagId, @NonNull List<Question> questions) {
        mName = name;
        mFlagId = flagId;
        mQuestions = questions;
    }

    //Accessors
    public String getName() {
        return mName;
    }
    public int getFlagId() {
        return mFlagId;
    }
    public List<Question> getQuestions() {
        return mQuestions;
    }
}
