package curtin.krados.funwithflags;

public class TwoNameQ extends Question {
    public TwoNameQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 3, 2, isSpecial, correctAnswer, answers);
        if (answers.length != 3) {
            throw new IllegalArgumentException("TwoNameQ must have two answers");
        }
    }
}
