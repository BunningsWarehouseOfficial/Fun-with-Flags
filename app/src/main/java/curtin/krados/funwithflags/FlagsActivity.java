package curtin.krados.funwithflags;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FlagsActivity extends AppCompatActivity {
    private static final String START = "curtin.krados.funwithflags.start";
    private static final String TARGET = "curtin.krados.funwithflags.target";

    private LayoutSelectorFragment mFragA;
    private FlagsFragment mFragB;
    private StatusBarFragment mFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        //Setting up the fragments
        FragmentManager fm = getSupportFragmentManager();
        mFragA = (LayoutSelectorFragment) fm.findFragmentById(R.id.layoutSelectorFrame);
        mFragB = (FlagsFragment) fm.findFragmentById(R.id.flagsFrame);
        mFragC = (StatusBarFragment) fm.findFragmentById(R.id.statusBarFrame);
        FragmentTransaction ft = fm.beginTransaction();
        if (mFragA == null) {
            mFragA = new LayoutSelectorFragment();
            ft.add(R.id.layoutSelectorFrame, mFragA);
        }
        if (mFragB == null) {
            mFragB = new FlagsFragment();
            ft.add(R.id.flagsFrame, mFragB);
        }
        if (mFragC == null) {
            mFragC = new StatusBarFragment();
            ft.add(R.id.statusBarFrame, mFragC);
        }
        ft.commit();
    }

    //Decoupling method for starting the activity
    public static Intent getIntent(Context c, int startPoints, int targetPoints) {
        Intent intent = new Intent(c, FlagsActivity.class);
        intent.putExtra(START, startPoints);
        intent.putExtra(TARGET, targetPoints);
        return intent;
    }
}
