package su.pushnoe.vk;

import android.app.Application;

import com.vk.sdk.VKSdk;

import su.pushnoe.vk.di.component.ApplicationComponent;
import su.pushnoe.vk.di.component.DaggerApplicationComponent;
import su.pushnoe.vk.di.module.ApplicationModule;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        VKSdk.initialize(this);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent(){
        return sApplicationComponent;
    }
}
