package curtin.krados.funwithflags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class LayoutSelectorFragment extends Fragment {
    private boolean mLayoutVertical = true;

    private ImageButton mSingleLayoutButton;
    private ImageButton mDoubleLayoutButton;
    private ImageButton mTripleLayoutButton;
    private ImageButton mDirectionLayoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup ui, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_layout_selector, ui, false);

        //Retrieving references
        mSingleLayoutButton = (ImageButton) view.findViewById(R.id.singleLayoutButton);
        mDoubleLayoutButton = (ImageButton) view.findViewById(R.id.doubleLayoutButton);
        mTripleLayoutButton = (ImageButton) view.findViewById(R.id.tripleLayoutButton);
        mDirectionLayoutButton = (ImageButton) view.findViewById(R.id.directionLayoutButton);

        //Implementing callbacks / setting up event handlers
        mSingleLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutVertical) {
                    //TODO actual changing of layout
                }
                else {
                    //TODO actual changing of layout
                }
            }
        });
        mDoubleLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutVertical) {
                    //TODO actual changing of layout
                }
                else {
                    //TODO actual changing of layout
                }
            }
        });
        mTripleLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutVertical) {
                    //TODO actual changing of layout
                }
                else {
                    //TODO actual changing of layout
                }
            }
        });
        mDirectionLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutVertical) {
                    //Switching to horizontal layout button images
                    mSingleLayoutButton.setImageResource(R.drawable.single_horizontal);
                    mDoubleLayoutButton.setImageResource(R.drawable.double_horizontal);
                    mTripleLayoutButton.setImageResource(R.drawable.triple_horizontal);
                    mDirectionLayoutButton.setImageResource(R.drawable.down_arrow);

                    //Switching to horizontal layout button content descriptions
                    mSingleLayoutButton.setContentDescription(getString(R.string.single_layout_horizontal));
                    mDoubleLayoutButton.setContentDescription(getString(R.string.double_layout_horizontal));
                    mTripleLayoutButton.setContentDescription(getString(R.string.triple_layout_horizontal));
                    mDirectionLayoutButton.setContentDescription(getString(R.string.layout_horizontal));
                    mLayoutVertical = false;

                    //TODO actual changing of layout
                }
                else {
                    //Switching to vertical layout button images
                    mSingleLayoutButton.setImageResource(R.drawable.single_vertical);
                    mDoubleLayoutButton.setImageResource(R.drawable.double_vertical);
                    mTripleLayoutButton.setImageResource(R.drawable.triple_vertical);
                    mDirectionLayoutButton.setImageResource(R.drawable.right_arrow);

                    //Switching to vertical layout button content descriptions
                    mSingleLayoutButton.setContentDescription(getString(R.string.single_layout_vertical));
                    mDoubleLayoutButton.setContentDescription(getString(R.string.double_layout_vertical));
                    mTripleLayoutButton.setContentDescription(getString(R.string.triple_layout_vertical));
                    mDirectionLayoutButton.setContentDescription(getString(R.string.layout_vertical));
                    mLayoutVertical = true;

                    //TODO actual changing of layout
                }
            }
        });

        return view;
    }
}
