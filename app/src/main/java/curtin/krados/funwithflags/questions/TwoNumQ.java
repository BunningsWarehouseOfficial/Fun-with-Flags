package curtin.krados.funwithflags.questions;

public class TwoNumQ extends Question {
    public TwoNumQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 5, 3, isSpecial, correctAnswer, answers);
        if (answers.length != 2) {
            throw new IllegalArgumentException("TwoNumQ must have two answers");
        }
    }
}
