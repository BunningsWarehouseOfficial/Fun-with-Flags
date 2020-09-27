package curtin.krados.funwithflags;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import curtin.krados.funwithflags.questions.Question;

public class SelectQuestionFragment extends Fragment {
    //RecyclerView ViewHolder implementation
    private class QuestionViewHolder extends RecyclerView.ViewHolder {
        private Button mQuestionButton;

        //Constructor
        public QuestionViewHolder(LayoutInflater li, ViewGroup parent) {
            super(li.inflate(R.layout.grid_cell_question, parent, false));

            //Retrieving references
            mQuestionButton  = (Button) itemView.findViewById(R.id.questionButton);
        }

        public void bind(final Question question, int questionNum) {
            String header;
            String points;
            String penalty;

            if (question.isSpecial()) {
                String special = getString(R.string.question_special);
                header = getString(R.string.question_header, questionNum, special);
            }
            else {
                header = getString(R.string.question_header, questionNum, "");
            }
            points = getString(R.string.question_points, question.getPoints());
            penalty = getString(R.string.question_penalty, question.getPenalty());
            mQuestionButton.setText(getString(R.string.question_button, header, points, penalty));
            mQuestionButton.setContentDescription(getString(R.string.question_button_description, questionNum));
            if (question.isAnswered()) {
                mQuestionButton.setEnabled(false);
                mQuestionButton.setBackgroundColor(Color.parseColor("#aaaaaa"));
            }
            else {
                mQuestionButton.setEnabled(true);
            }

            mQuestionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GameInfo.getInstance().setCurrentQuestion(question);
                    ((SelectQuestionActivity) getActivity()).swapToAnswers();
                }
            });
        }
    }

    //RecyclerView Adapter implementation
    private class QuestionAdapter extends RecyclerView.Adapter<SelectQuestionFragment.QuestionViewHolder> {
        private List<Question> mQuestions;
        private GameInfo mInfo;

        //Constructor
        public QuestionAdapter(List<Question> questions) {
            mQuestions = questions;
            mInfo = GameInfo.getInstance();
        }

        @Override
        public int getItemCount() {
            return mQuestions.size();
        }

        @Override
        public SelectQuestionFragment.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity()); //Call the fragment method
            return new SelectQuestionFragment.QuestionViewHolder(li, parent);
        }

        @Override
        public void onBindViewHolder(SelectQuestionFragment.QuestionViewHolder vh, int index) {
            int questionNum = index + 1; //Index starts at 0, but we don't want a "Question 0"
            vh.bind(mQuestions.get(index), questionNum);
        }
    }

    // ========== //

    private List<Question> mQuestions;
    private LayoutViewModel mModel;
    private RecyclerView mRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_flag_selector, ui, false);
        mModel = new ViewModelProvider(requireActivity()).get(LayoutViewModel.class);
        GameInfo info = GameInfo.getInstance();
        mQuestions = info.getCurrentCountry().getQuestions();

        //Setting up map Recycler View
        mRv = (RecyclerView) view.findViewById(R.id.flagsRecyclerView);
        updateLayoutManager(mModel.getLayoutNumber().getValue(), mModel.isVerticalLayout().getValue());
        QuestionAdapter adapter = new QuestionAdapter(mQuestions);
        mRv.setAdapter(adapter);

        //Setting up observer listeners to update the UI when a layout parameter changes
        mModel.getLayoutNumber().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer layoutNumber) {
                updateLayoutManager(layoutNumber, mModel.isVerticalLayout().getValue());
            }
        });
        mModel.isVerticalLayout().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isVertical) {
                updateLayoutManager(mModel.getLayoutNumber().getValue(), isVertical);
            }
        });

        return view;
    }

    //PRIVATE METHODS
    private void updateLayoutManager(Integer layoutNumber, Boolean isVertical) {
        if (isVertical) {
            mRv.setLayoutManager(new GridLayoutManager(
                    getActivity(),
                    layoutNumber, //spanCount: no. of columns in recyclerView
                    GridLayoutManager.VERTICAL, //The orientation of the recyclerView
                    false));
        }
        else {
            mRv.setLayoutManager(new GridLayoutManager(
                    getActivity(),
                    layoutNumber, //spanCount: no. of columns in recyclerView
                    GridLayoutManager.HORIZONTAL, //The orientation of the recyclerView
                    false));
        }
    }
}
