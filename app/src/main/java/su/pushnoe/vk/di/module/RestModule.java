package su.pushnoe.vk.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import su.pushnoe.vk.rest.RestClient;
import su.pushnoe.vk.rest.api.WallApi;

/**
 * Класс Модуля РЕСТ
 */
@Module
public class RestModule {

    private RestClient mRestClient;

    /**
     *
     */
    public RestModule() {
        mRestClient = new RestClient();
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    public RestClient providerRestClient(){
        return mRestClient;
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
