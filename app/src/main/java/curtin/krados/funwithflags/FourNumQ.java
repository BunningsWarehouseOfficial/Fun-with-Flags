package curtin.krados.funwithflags;

public class FourNumQ extends Question {
    public FourNumQ(String questionText, String[] answers, boolean isSpecial, int correctAnswer) {
        super(questionText, 7, 2, isSpecial, correctAnswer, answers);
        if (answers.length != 4) {
            throw new IllegalArgumentException("FourNumQ must have four answers");
        }
    }
}
