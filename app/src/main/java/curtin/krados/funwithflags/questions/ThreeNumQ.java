package curtin.krados.funwithflags.questions;

public class ThreeNumQ extends Question {
    public ThreeNumQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 6, 3, isSpecial, correctAnswer, answers);
        if (answers.length != 3) {
            throw new IllegalArgumentException("ThreeNumQ must have three answers");
        }
    }
}
