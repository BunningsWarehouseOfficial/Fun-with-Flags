package curtin.krados.funwithflags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StatusBarFragment extends Fragment {
    private TextView mStatusBarPoints;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_status_bar, ui, false);

        //Retrieving references
        mStatusBarPoints = (TextView) view.findViewById(R.id.statusBarPoints);

        //Initialising point value
        int points = GameInfo.getInstance().getStartPoints();
        mStatusBarPoints.setText(getString(R.string.status_points, points));

        //TODO Updating point value (Observers with ViewModel? Or at least implement livedata into GameInfo)
        return view;
    }
}
