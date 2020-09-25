package curtin.krados.funwithflags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlagsFragment extends Fragment {
    private List<Country> mCountries;

    //RecyclerView ViewHolder implementation
    private class FlagViewHolder extends RecyclerView.ViewHolder {
        private ImageButton mFlagImage;
        private TextView mFlagName;

        //Constructor
        public FlagViewHolder(LayoutInflater li, ViewGroup parent) {
            super(li.inflate(R.layout.grid_cell_flag, parent, false));

            //Retrieving references
            mFlagImage = itemView.findViewById(R.id.flagImage);
            mFlagName  = itemView.findViewById(R.id.flagName);

            //Setting square to correct size //TODO clear if not needed
//            int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
//            ViewGroup.LayoutParams lp = itemView.getLayoutParams();
//            lp.width = size;
//            lp.height = size;
        }

        public void bind(Country country) {
            mFlagImage.setImageResource(country.getFlagId());

            String name = country.getName();
            mFlagImage.setContentDescription(getString(R.string.country_flag, name));
            mFlagName.setText(name);
        }
    }

    //RecyclerView Adapter implementation
    private class FlagAdapter extends RecyclerView.Adapter<FlagViewHolder> {
        private List<Country> mCountries;
        private GameInfo mInfo;

        //Constructor
        public FlagAdapter(List<Country> countries) {
            mCountries = countries;
            mInfo = GameInfo.getInstance(); //TODO check this later
        }

        @Override
        public int getItemCount() {
            return mCountries.size();
        }

        @Override
        public FlagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity()); //Call the fragment method
            return new FlagViewHolder(li, parent);
        }

        @Override
        public void onBindViewHolder(FlagViewHolder vh, int index) {
            vh.bind(mCountries.get(index));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_flag_selector, ui, false);
        mCountries = GameInfo.getInstance().getCountries();

        //Setting up map Recycler View
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.flagsRecyclerView);
        rv.setLayoutManager(new GridLayoutManager(
                getActivity(), //TODO perhaps generalise this using singleton for reuse if somebody wanted to change default layout state
                2,
                GridLayoutManager.VERTICAL,
                false));
        FlagAdapter adapter = new FlagAdapter(mCountries);
        rv.setAdapter(adapter);

        //Retrieving references
        //...

        //TODO Updating layout
        return view;
    }
}
