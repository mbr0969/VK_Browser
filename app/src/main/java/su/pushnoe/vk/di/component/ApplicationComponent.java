package su.pushnoe.vk.di.component;


import javax.inject.Singleton;

import dagger.Component;
import su.pushnoe.vk.common.manager.*;
import su.pushnoe.vk.di.module.ApplicationModule;
import su.pushnoe.vk.di.module.ManagerModule;
import su.pushnoe.vk.di.module.RestModule;
import su.pushnoe.vk.mvp.presenter.*;
import su.pushnoe.vk.ui.activity.BaseActivity;
import su.pushnoe.vk.ui.activity.MainActivity;
import su.pushnoe.vk.ui.fragment.NewsFeedFragment;
import su.pushnoe.vk.ui.holder.NewsItemBodyHolder;
import su.pushnoe.vk.ui.holder.NewsItemFooterHolder;

/**
 * Интерфейс приложения
 */
@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {


    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);
    //Holder
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);

    //presenter
    void inject(NewsFeedPresenter presenter);

    //managers
    void inject(NetworkManager manager);


}
