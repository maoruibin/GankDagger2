package me.gudong.dagger;

import android.app.Application;
import android.content.Context;

import me.gudong.dagger.reject.components.AppComponent;
import me.gudong.dagger.reject.components.DaggerAppComponent;
import me.gudong.dagger.reject.models.ApiServiceModule;
import me.gudong.dagger.reject.models.AppModule;


/**
 * Created by GuDong on 2015/12/24.
 */
public class AppApplication  extends Application{

    private AppComponent appComponent;

    public static AppApplication get(Context context){
        return (AppApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
