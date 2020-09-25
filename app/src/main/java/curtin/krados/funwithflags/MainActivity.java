package curtin.krados.funwithflags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int mStartPoints;
    private int mTargetPoints;
    private GameInfo mInfo;

    private ImageView mAppLogo;
    private TextView mStartPointsText;
    private TextView mTargetPointsText;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising point values
        Random rand = new Random(); //Create a seed
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
                Intent intent = FlagsActivity.getIntent(MainActivity.this, mStartPoints, mTargetPoints);
                startActivity(intent);
            }
        });

        //Initialising text
        mStartPointsText.setText(getString(R.string.start_points, mStartPoints));
        mTargetPointsText.setText(getString(R.string.target_points, mTargetPoints));
    }
}

//HIGH PRIORITY


//MEDIUM PRIORITY
//TODO Ensure statusText changes between points and victory status

//LOW PRIORITY
//TODO Set content description of layout selector images to change as the images themselves change
//TODO Put layout files into directories for each activity (see GeoQuiz and textbook)