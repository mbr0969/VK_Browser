package su.pushnoe.vk;

import android.app.Application;

import com.vk.sdk.VKSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;
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

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent(){
        return sApplicationComponent;
    }
}
