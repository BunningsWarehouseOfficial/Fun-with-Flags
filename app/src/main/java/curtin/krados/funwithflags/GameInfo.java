package curtin.krados.funwithflags;

public class GameInfo {
    //Singleton
    private static GameInfo sInstance;
    public static GameInfo getInstance() {
        if (sInstance == null) {
            sInstance = new GameInfo();
        }
        return sInstance;
    }

    private int mStartPoints;
    private int mTargetPoints;

    //Constructor
    private GameInfo() {
        mStartPoints = 0;
        mTargetPoints = 0;
    }

    //Accessors
    public int getStartPoints() {
        return mStartPoints;
    }
    public int getTargetPoints() {
        return mTargetPoints;
    }

    //Mutators
    public void setStartPoints(int startPoints) {
        mStartPoints = startPoints;
    }
    public void setTargetPoints(int targetPoints) {
        mTargetPoints = targetPoints;
    }
}
