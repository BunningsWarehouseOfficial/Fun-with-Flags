package curtin.krados.funwithflags.questions;

public class TwoNameQ extends Question {
    public TwoNameQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 3, 2, isSpecial, correctAnswer, answers);
        if (answers.length != 2) {
            throw new IllegalArgumentException("TwoNameQ must have two answers");
        }
    }
}
