package curtin.krados.funwithflags.questions;

public class FourNameQ extends Question {
    public FourNameQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 5, 1, isSpecial, correctAnswer, answers);
        if (answers.length != 4) {
            throw new IllegalArgumentException("FourNameQ must have four answers");
        }
    }
}
