package su.pushnoe.vk.di.component;


import javax.inject.Singleton;

import dagger.Component;
import su.pushnoe.vk.di.module.ApplicationModule;
import su.pushnoe.vk.di.module.ManagerModule;
import su.pushnoe.vk.di.module.RestModule;
import su.pushnoe.vk.ui.activity.BaseActivity;
import su.pushnoe.vk.ui.activity.MainActivity;
import su.pushnoe.vk.ui.fragment.NewsFeedFragment;

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
}
