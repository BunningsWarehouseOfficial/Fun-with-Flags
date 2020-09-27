package curtin.krados.funwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import curtin.krados.funwithflags.questions.Question;

public class FlagsFragment extends Fragment {
    //RecyclerView ViewHolder implementation
    private class FlagViewHolder extends RecyclerView.ViewHolder {
        private ImageButton mFlagImage;
        private TextView mFlagName;
        private GameInfo info;

        //Constructor
        public FlagViewHolder(LayoutInflater li, ViewGroup parent) {
            super(li.inflate(R.layout.grid_cell_flag, parent, false));
            info = GameInfo.getInstance();

            //Retrieving references
            mFlagImage = (ImageButton) itemView.findViewById(R.id.flagImage);
            mFlagName  = (TextView) itemView.findViewById(R.id.flagName);
        }

        public void bind(final Country country) {
            mFlagImage.setImageResource(country.getFlagId());

            String name = country.getName();
            mFlagImage.setContentDescription(getString(R.string.country_flag, name));
            mFlagName.setText(name);

            mFlagImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setCurrentCountry(country);

                    //Check if there are any unredeemed special points to be applied
                    if (info.getSpecialPoints() != 0) {
                        for (Question q : country.getQuestions()) {
                            q.setPoints(q.getPoints() + GameInfo.SPECIAL_BONUS);
                        }
                        Toast.makeText(getActivity(), R.string.applied_special, Toast.LENGTH_SHORT).show();
                        info.setSpecialPoints(0); //Reset unredeemed special points
                    }

                    Intent intent = SelectQuestionActivity.getIntent(getActivity());
                    startActivity(intent);
                }
            });
        }
    }

    //RecyclerView Adapter implementation
    private class FlagAdapter extends RecyclerView.Adapter<FlagViewHolder> {
        private List<Country> mCountries;

        //Constructor
        public FlagAdapter(List<Country> countries) {
            mCountries = countries;
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

    // ========== //

    private List<Country> mCountries;
    LayoutViewModel model;
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_flag_selector, ui, false);
        model = new ViewModelProvider(requireActivity()).get(LayoutViewModel.class);
        GameInfo info = GameInfo.getInstance();
        mCountries = info.getCountries();

        //Setting up map Recycler View
        rv = (RecyclerView) view.findViewById(R.id.flagsRecyclerView);
        updateLayoutManager(model.getLayoutNumber().getValue(), model.isVerticalLayout().getValue());
        FlagAdapter adapter = new FlagAdapter(mCountries);
        rv.setAdapter(adapter);

        //Setting up observer listeners to update the UI when a layout parameter changes
        model.getLayoutNumber().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer layoutNumber) {
                updateLayoutManager(layoutNumber, model.isVerticalLayout().getValue());
            }
        });
        model.isVerticalLayout().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isVertical) {
                updateLayoutManager(model.getLayoutNumber().getValue(), isVertical);
            }
        });

        return view;
    }

    //PRIVATE METHODS
    private void updateLayoutManager(Integer layoutNumber, Boolean isVertical) {
        if (isVertical) {
            rv.setLayoutManager(new GridLayoutManager(
                    getActivity(),
                    layoutNumber, //spanCount: no. of columns in recyclerView
                    GridLayoutManager.VERTICAL, //The orientation of the recyclerView
                    false));
        }
        else {
            rv.setLayoutManager(new GridLayoutManager(
                    getActivity(),
                    layoutNumber, //spanCount: no. of columns in recyclerView
                    GridLayoutManager.HORIZONTAL, //The orientation of the recyclerView
                    false));
        }
    }
}
