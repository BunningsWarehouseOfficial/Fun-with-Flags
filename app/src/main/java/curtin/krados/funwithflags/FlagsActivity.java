package curtin.krados.funwithflags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FlagsActivity extends AppCompatActivity {
    private static final String START = "curtin.krados.funwithflags.start";
    private static final String TARGET = "curtin.krados.funwithflags.target";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);
    }

    //Decoupling method for starting the activity
    public static Intent getIntent(Context c, int startPoints, int targetPoints) {
        Intent intent = new Intent(c, FlagsActivity.class);
        intent.putExtra(START, startPoints);
        intent.putExtra(TARGET, targetPoints);
        return intent;
    }
}
