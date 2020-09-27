package curtin.krados.funwithflags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SelectQuestionActivity extends AppCompatActivity {
    private FragmentManager mFm;
    private LayoutSelectorFragment mFragA;
    private SelectQuestionFragment mFragD;
    private StatusBarFragment mFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_question);

        //Setting up the fragments
        mFm = getSupportFragmentManager();
        mFragA = (LayoutSelectorFragment) mFm.findFragmentById(R.id.layoutSelectorFrame);
        mFragD = (SelectQuestionFragment) mFm.findFragmentById(R.id.questionsFrame);
        mFragC = (StatusBarFragment) mFm.findFragmentById(R.id.statusBarFrame);
        FragmentTransaction ft = mFm.beginTransaction();
        if (mFragA == null) {
            mFragA = new LayoutSelectorFragment();
            ft.add(R.id.layoutSelectorFrame, mFragA);
        }
        if (mFragD == null) {
            mFragD = new SelectQuestionFragment();
            ft.add(R.id.questionsFrame, mFragD);
        }
        if (mFragC == null) {
            GameInfo.getInstance().setButtonNeeded(true);
            mFragC = new StatusBarFragment();
            ft.add(R.id.statusBarFrame, mFragC);
        }
        ft.commit();
    }

    //Decoupling method for starting the activity
    public static Intent getIntent(Context c) {
        Intent intent = new Intent(c, SelectQuestionActivity.class);
        return intent;
    }

    //todo comment
    public void swapToAnswers() {
        FragmentTransaction ft = mFm.beginTransaction();
        ft.replace(R.id.questionsFrame, new AnswerQuestionFragment())
                .replace(R.id.statusBarFrame, new StatusBarFragment())
                .commit();
        findViewById(R.id.layoutSelectorFrame).setVisibility(View.INVISIBLE);
    }
    public void swapToQuestions() {
        FragmentTransaction ft = mFm.beginTransaction();
        ft.replace(R.id.questionsFrame, new SelectQuestionFragment())
                .replace(R.id.statusBarFrame, new StatusBarFragment())
                .commit();
        findViewById(R.id.layoutSelectorFrame).setVisibility(View.VISIBLE);
    }
}
