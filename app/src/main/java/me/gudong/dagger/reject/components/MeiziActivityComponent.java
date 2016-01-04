package me.gudong.dagger.reject.components;

import dagger.Component;
import me.gudong.dagger.reject.ActivityScope;
import me.gudong.dagger.reject.models.MeiziActivityModule;
import me.gudong.dagger.ui.activity.MeiziActivity;

/**
 * Created by GuDong on 1/4/16 16:53.
 * Contact with 1252768410@qq.com.
 */
@ActivityScope
@Component(modules = MeiziActivityModule.class)
public interface MeiziActivityComponent {
    MeiziActivity inject(MeiziActivity meiziActivity);
}


//@ActivityScope
//@Component(modules = MainActivityModule.class,dependencies = AppComponent.class)
//public interface MainActivityComponent {
//
//    MainActivity inject(MainActivity mainActivity);
//
//}
