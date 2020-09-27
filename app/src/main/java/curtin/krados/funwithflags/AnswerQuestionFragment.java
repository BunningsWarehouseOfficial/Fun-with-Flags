package curtin.krados.funwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import curtin.krados.funwithflags.questions.Question;

public class AnswerQuestionFragment extends Fragment {
    private GameInfo info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        info = GameInfo.getInstance();

        final Question question = info.getCurrentQuestion();
        String[] answers = question.getAnswers();
        int numAnswers = answers.length;

        //Inflating the correct layout given the number of answers to the question
        View view;
        if (numAnswers == 2) {
            view = inflater.inflate(R.layout.fragment_question_2_answers, ui, false);
        }
        else if (numAnswers == 3) {
            view = inflater.inflate(R.layout.fragment_question_3_answers, ui, false);

            //Retrieving layout specific references
            final Button answerC = (Button) view.findViewById(R.id.answerC);

            //Implementing callbacks / setting up event handlers
            answerC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(question, answerC.getText().toString());
                }
            });

            //Initialising layout specific text
            answerC.setText(answers[2]);
        }
        else { //numAnswers == 4
            view = inflater.inflate(R.layout.fragment_question_4_answers, ui, false);

            //Retrieving layout specific references
            final Button answerC = (Button) view.findViewById(R.id.answerC);
            final Button answerD = (Button) view.findViewById(R.id.answerD);

            //Implementing callbacks / setting up event handlers
            answerC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(question, answerC.getText().toString());
                }
            });
            answerD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(question, answerD.getText().toString());
                }
            });

            //Initialising layout specific text
            answerC.setText(answers[2]);
            answerD.setText(answers[3]);
        }

        //Retrieving common references
        TextView questionText = (TextView) view.findViewById(R.id.questionText);
        final Button answerA  = (Button) view.findViewById(R.id.answerA);
        final Button answerB  = (Button) view.findViewById(R.id.answerB);

        //Implementing callbacks / setting up event handlers
        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(question, answerA.getText().toString());
            }
        });
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(question, answerB.getText().toString());
            }
        });

        //Initialising text
        questionText.setText(question.getQuestionText());
        answerA.setText(answers[0]);
        answerB.setText(answers[1]);

        return view;
    }

    private void checkAnswer(Question question, String answer) {
        int messageId;
        String message;
        String[] answers = question.getAnswers();

        if (answer.equals(answers[question.getCorrectAnswer() - 1])) {
            messageId = R.string.correct;
            message = getString(messageId, question.getPenalty());
            if (!info.isEnded()) {
                info.setPoints(info.getPoints().getValue() + question.getPoints());

                if (question.isSpecial()) {
                    info.setSpecialPoints(GameInfo.SPECIAL_BONUS);
                }
            }
        }
        else {
            messageId = R.string.incorrect;
            message = getString(messageId, question.getPenalty());
            if (!info.isEnded()) {
                info.setPoints(info.getPoints().getValue() - question.getPenalty());
            }
        }
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

        question.setAnswered(true);
        ((SelectQuestionActivity) getActivity()).swapToQuestions();
    }
}
