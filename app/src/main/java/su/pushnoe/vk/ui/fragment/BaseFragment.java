package su.pushnoe.vk.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;


/**
 * Класс базового Фрагмета
 */
public abstract class BaseFragment extends MvpAppCompatFragment {

    /**
     *
     * @return
     */
    @LayoutRes
    protected abstract int getMainContentLayout();

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getMainContentLayout(),container,false);
    }

    /**
     *
     * @param context
     * @return
     */
    public String createToolbarTitle(Context context){
        return context.getString(onCreateToolbarTitle());
    }

    /**
     *
     * @return
     */
    @StringRes
    public abstract int onCreateToolbarTitle();
}
