package su.pushnoe.vk.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import su.pushnoe.vk.common.manager.MyFragmentManager;
import su.pushnoe.vk.common.manager.NetworkManager;

/**
 * Класс манаджера модулей
 */
@Module
public class ManagerModule {

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    MyFragmentManager provaderMyFragmentManager(){
        return  new MyFragmentManager();
    }

    @Singleton
    @Provides
    NetworkManager providerNetworkManager(){
        return new NetworkManager();
    }
}
