package me.gudong.dagger.mvp.views;

import android.widget.ImageView;

/**
 * Created by GuDong on 1/4/16 16:13.
 * Contact with 1252768410@qq.com.
 */
public interface IMeiziView {

    ImageView getImageView();

    void onPrepareSave();

    void onSaveSuccess();

    void onSaveFail();

    void onSaveFinish();
}
