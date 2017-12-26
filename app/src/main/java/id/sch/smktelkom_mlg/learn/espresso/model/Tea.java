package id.sch.smktelkom_mlg.learn.espresso.model;

/**
 * Created by rongrong on 26/12/2017.
 */

public class Tea {

    private String mTeaName;
    private int mImageResourceId;

    public Tea(String teaName, int imageResourceId) {
        mTeaName = teaName;
        mImageResourceId = imageResourceId;
    }

    public String getTeaName() {
        return mTeaName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
