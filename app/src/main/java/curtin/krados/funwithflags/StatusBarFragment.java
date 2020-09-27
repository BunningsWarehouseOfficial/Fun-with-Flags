package curtin.krados.funwithflags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

public class StatusBarFragment extends Fragment {
    private TextView mStatusBarPoints;
    private Button mBackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        final GameInfo info = GameInfo.getInstance();
        View view;
        if (info.isButtonNeeded()) {
            view = inflater.inflate(R.layout.fragment_status_bar_button, ui, false);

            //Retrieving variation specific references
            mBackButton = view.findViewById(R.id.backButton);

            //Implementing callbacks / setting up event handlers
            mBackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
        }
        else {
            view = inflater.inflate(R.layout.fragment_status_bar, ui, false);
        }

        //Retrieving references
        mStatusBarPoints = (TextView) view.findViewById(R.id.statusBarPoints);

        //Initialising point value
        int points = GameInfo.getInstance().getPoints().getValue();
        mStatusBarPoints.setText(getString(R.string.status_points, points));

        //Setting up observer listeners to update the UI when a layout parameter changes
        info.getPoints().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer isVertical) {
                int points = info.getPoints().getValue();
                mStatusBarPoints.setText(getString(R.string.status_points, points));
                if (points <= 0) { //Check for loss condition
                    info.setEnded(true);
                    getActivity().finish();
                }
                if (points >= info.getTargetPoints() && !info.isEnded()) { //Check for win condition
                    info.setEnded(true);
                    Toast.makeText(getActivity(), R.string.status_victory, Toast.LENGTH_LONG).show();
                }
            }
        });

        //TODO Updating point value (Observers with ViewModel? Or at least implement livedata into GameInfo)
        return view;
    }
}
