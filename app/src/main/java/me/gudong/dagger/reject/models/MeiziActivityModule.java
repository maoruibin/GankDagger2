package me.gudong.dagger.reject.models;

import dagger.Module;
import dagger.Provides;
import me.gudong.dagger.mvp.presenters.MeiziPresenter;
import me.gudong.dagger.reject.ActivityScope;
import me.gudong.dagger.ui.activity.MeiziActivity;

/**
 * Created by GuDong on 1/4/16 16:51.
 * Contact with 1252768410@qq.com.
 */
@Module
public class MeiziActivityModule {
    private MeiziActivity mMeiziActivity;

    public MeiziActivityModule(MeiziActivity meiziActivity) {
        mMeiziActivity = meiziActivity;
    }

    @Provides
    @ActivityScope
    MeiziActivity provideActivity() {
        return mMeiziActivity;
    }


    @Provides
    @ActivityScope
    MeiziPresenter provideMeiziActivityPresenter() {
        return new MeiziPresenter();
    }
}
