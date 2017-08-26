package su.pushnoe.vk.di.module;


import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Класс модуля приложения
 */
@Module
public class ApplicationModule {

    private Application mApplication;

    /**
     *
     * @param application
     */
    public ApplicationModule(Application application){
        mApplication = application;
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    public Context provaderCoontext(){
        return mApplication;
    }

    /**
     *
     * @param context
     * @return
     */
    @Provides
    @Singleton
    Typeface provaderGoogleTypeface(Context context){
        return  Typeface.createFromAsset(context.getAssets(),"MaterialIcons-Regular.ttf" );
    }


}
