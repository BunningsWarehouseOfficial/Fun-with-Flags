package curtin.krados.funwithflags;

public class TwoNumQ extends Question {
    public TwoNumQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 5, 3, isSpecial, correctAnswer, answers);
        if (answers.length != 3) {
            throw new IllegalArgumentException("TwoNumQ must have two answers");
        }
    }
}
