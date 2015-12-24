package me.gudong.dagger.mvp.model;


import me.gudong.dagger.mvp.model.entity.GankData;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by GuDong on 12/22/15 23:59.
 * Contact with 1252768410@qq.com.
 */
public interface ApiService {

    @GET("/day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year")int year, @Path("month")int month, @Path("day")int day);
}
