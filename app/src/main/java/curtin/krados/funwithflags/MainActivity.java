package curtin.krados.funwithflags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private GameInfo mInfo;
    private int mStartPoints;
    private int mTargetPoints;
    private Random rand;

    private ImageView mAppLogo;
    private TextView mStartPointsText;
    private TextView mTargetPointsText;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising point values
        rand = new Random(); //Create a seed
        mStartPoints = rand.nextInt(15 - 5) + 5;
        mTargetPoints = rand.nextInt(35 - 25) + 25;

        //Updating singleton values
        mInfo = GameInfo.getInstance();
        mInfo.setPoints(mStartPoints);
        mInfo.setTargetPoints(mTargetPoints);

        //Retrieving references
        mAppLogo          = (ImageView) findViewById(R.id.appLogo);
        mStartPointsText  = (TextView) findViewById(R.id.startPointsText);
        mTargetPointsText = (TextView) findViewById(R.id.targetPointsText);
        mStartButton      = (Button) findViewById(R.id.startButton);

        //Implementing callbacks / setting up event handlers
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FlagsActivity.getIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        initialiseText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mInfo.getPoints().getValue() <= 0) {
            mStartPoints = rand.nextInt(15 - 5) + 5;
            mTargetPoints = rand.nextInt(35 - 25) + 25;
            mInfo.setPoints(mStartPoints);
            mInfo.setTargetPoints(mTargetPoints);
            mInfo.setEnded(false);
            initialiseText();
            Toast.makeText(this, R.string.status_loss, Toast.LENGTH_LONG).show();
            Toast.makeText(this, R.string.restarted, Toast.LENGTH_SHORT).show();
        }
    }

    //PRIVATE METHODS
    private void initialiseText() {
        mStartPointsText.setText(getString(R.string.start_points, mStartPoints));
        mTargetPointsText.setText(getString(R.string.target_points, mTargetPoints));
    }
}

//HIGH PRIORITY
//TODO Fix ultra-wide horizontal spacing between flags for 3 row layout
//TODO Ensure statusText changes between points and victory status

//MEDIUM PRIORITY
//TODO Fix issue with double line text in flag cells for 3 column layout

//LOW PRIORITY
//TODO Change TrueFalseQ to override parent method instead of pre-filling incorrect value in constructor before correcting
//TODO Set content description of layout selector images to change as the images themselves change
//TODO Put layout files into directories for each activity (see GeoQuiz and textbook)
//TODO Make the flag the background in question screens