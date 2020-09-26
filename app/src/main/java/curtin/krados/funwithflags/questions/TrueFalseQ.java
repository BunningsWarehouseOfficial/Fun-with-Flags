package curtin.krados.funwithflags.questions;

public class TrueFalseQ extends Question {
    public TrueFalseQ(String questionText, boolean isSpecial, boolean correctAnswer) {
        super(questionText, 3, 2, isSpecial, 1,
              new String[] {"True", "False"});

        if (correctAnswer == true) {
            super.setCorrectAnswer(1); //1 represents the answer "True"
        }
        else {
            super.setCorrectAnswer(2); //2 represents the answer "False"
        }
    }
}
