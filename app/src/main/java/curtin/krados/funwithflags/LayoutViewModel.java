package curtin.krados.funwithflags;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LayoutViewModel extends ViewModel {
    private MutableLiveData<Integer> mLayoutNumber;   //Number of columns/rows in gridLayoutManager
    private MutableLiveData<Boolean> mVerticalLayout; //Determines orientation of gridLayoutManager

    //Constructor
    public LayoutViewModel() {
        mLayoutNumber = new MutableLiveData<>();
        mLayoutNumber.setValue(2);
        mVerticalLayout = new MutableLiveData<>();
        mVerticalLayout.setValue(true);
    }

    //Accessors / Observer Listener Methods
    public LiveData<Integer> getLayoutNumber() {
        return mLayoutNumber;
    }
    public LiveData<Boolean> isVerticalLayout() {
        return mVerticalLayout;
    }

    //Mutators / Observer Subject Methods
    public void updateLayoutNumber(Integer layoutNumber) {
        mLayoutNumber.setValue(layoutNumber);
    }
    public void updateVerticalLayout(boolean verticalLayout) {
        mVerticalLayout.setValue(verticalLayout);
    }
}
