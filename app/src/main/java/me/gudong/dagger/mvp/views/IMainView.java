package me.gudong.dagger.mvp.views;

import java.util.List;

import me.gudong.dagger.mvp.model.entity.Gank;

/**
 * Created by GuDong on 12/22/15 23:59.
 * Contact with 1252768410@qq.com.
 */
public interface IMainView {

    void showLoading();

    void hideLoading();

    void fillData(List<Gank> list);
}
