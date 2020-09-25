package curtin.krados.funwithflags;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {
    //Singleton
    private static GameInfo sInstance;
    public static GameInfo getInstance() {
        if (sInstance == null) {
            sInstance = new GameInfo();
        }
        return sInstance;
    }

    private int mPoints;
    private int mTargetPoints;
    private int mLayoutNumber;
    private boolean mVerticalLayout;
    private List<Country> mCountries;

    //Constructor
    private GameInfo() {
        mPoints = 0;
        mTargetPoints = 0;
        mLayoutNumber = 2;
        mVerticalLayout = true;
        mCountries = new ArrayList<>();

        //Hardcoded countries TODO finish, put actual questions in too
        mCountries.add(new Country("Antigua and Barbuda", R.drawable.flag_ag, null));
        mCountries.add(new Country("Albania", R.drawable.flag_al, null));
        mCountries.add(new Country("Australia", R.drawable.flag_au, null));
        mCountries.add(new Country("Azerbaijan", R.drawable.flag_az, null));
        mCountries.add(new Country("Bosnia and Herzegovina", R.drawable.flag_ba, null));
    }

    //Accessors
    public int getPoints() {
        return mPoints;
    }
    public int getTargetPoints() {
        return mTargetPoints;
    }
    public int getLayoutNumber() {
        return mLayoutNumber;
    }
    public boolean isVerticalLayout() {
        return mVerticalLayout;
    }
    public List<Country> getCountries() {
        return mCountries;
    }

    //Mutators
    public void setPoints(int points) {
        mPoints = points;
    }
    public void setTargetPoints(int targetPoints) {
        mTargetPoints = targetPoints;
    }
}
