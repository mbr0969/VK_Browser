package su.pushnoe.vk.model.view.counter;

import su.pushnoe.vk.R;

/**
 * Created by papa on 26.08.17.
 */

public class CounterViewModel {

    protected int mCount;
    protected int mIconColor = R.color.colorIconDis;
    protected int mTextColor = R.color.colorIconDis;

    public CounterViewModel(int mCount) {
        this.mCount = mCount;
        if (mCount > 0){
            setDefaultColor();
        }else {
            setDisableColor();
        }

    }

    private void setDefaultColor() {
        mIconColor = R.color.colorIcon;
        mTextColor = R.color.colorIcon;
    }

    private void setDisableColor() {
        mIconColor = R.color.colorIconDis;
        mTextColor = R.color.colorIconDis;
    }

    protected void setAccentColor(){
        mIconColor = R.color.colorAccent;
        mTextColor = R.color.colorAccent;
    }

    public int getCount() {
        return mCount;
    }

    public int getIconColor() {
        return mIconColor;
    }

    public int getTextColor() {
        return mTextColor;
    }
}
