package su.pushnoe.vk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.mvp.presenter.BaseFeedPresenter;
import su.pushnoe.vk.mvp.presenter.NewsFeedPresenter;
import su.pushnoe.vk.rest.api.WallApi;

/**
 *Класс фрагмета новостей
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    @InjectPresenter
    NewsFeedPresenter mPresenter;

    public NewsFeedFragment() {

    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    /**
     *
     * @return
     */
    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}
