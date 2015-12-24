package me.gudong.dagger.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.gudong.dagger.AppApplication;
import me.gudong.dagger.reject.components.AppComponent;


/**
 * Created by GuDong on 2015/6/10.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppApplication.get(this).getAppComponent());
    }

    protected abstract  void setupActivityComponent(AppComponent appComponent);
}
