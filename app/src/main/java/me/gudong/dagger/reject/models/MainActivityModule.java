package me.gudong.dagger.reject.models;


import dagger.Module;
import dagger.Provides;
import me.gudong.dagger.mvp.model.ApiService;
import me.gudong.dagger.mvp.presenters.MainActivityPresenter;
import me.gudong.dagger.reject.ActivityScope;
import me.gudong.dagger.ui.activity.MainActivity;

/**
 * Created by GuDong on 2015/6/10.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }


    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(ApiService apiService) {
        return new MainActivityPresenter( apiService);
    }


}
