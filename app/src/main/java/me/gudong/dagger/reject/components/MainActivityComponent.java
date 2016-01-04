package me.gudong.dagger.reject.components;


import me.gudong.dagger.reject.models.MainActivityModule;
import me.gudong.dagger.reject.ActivityScope;
import me.gudong.dagger.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by GuDong on 2015/6/10.
 */
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = AppComponent.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
