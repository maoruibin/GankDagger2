package me.gudong.dagger.reject.components;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import me.gudong.dagger.mvp.model.ApiService;
import me.gudong.dagger.reject.models.ApiServiceModule;
import me.gudong.dagger.reject.models.AppModule;

/**
 * Created by GuDong on 2015/12/24.
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {

    Application getApplication();

    ApiService getService();

}
