package curtin.krados.funwithflags;

public class ThreeNameQ extends Question {
    public ThreeNameQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 4, 2, isSpecial, correctAnswer, answers);
        if (answers.length != 3) {
            throw new IllegalArgumentException("ThreeNameQ must have three answers");
        }
    }
}
