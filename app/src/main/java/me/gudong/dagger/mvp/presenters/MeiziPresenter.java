package me.gudong.dagger.mvp.presenters;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import me.gudong.dagger.mvp.model.entity.Gank;
import me.gudong.dagger.mvp.views.IMeiziView;

/**
 * Created by GuDong on 1/4/16 16:12.
 * Contact with 1252768410@qq.com.
 */
public class MeiziPresenter {

    private IMeiziView mView;
    private Gank mGank;
    private Context mContext;

    public MeiziPresenter() {

    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void attachView(IMeiziView view) {
        mView = view;
        Log.i("-----", "---------------");
    }

    public void fillData(Gank gank) {
        mGank = gank;
    }

    public void onCreate() {
        Picasso.with(mContext)
                .load(mGank.url)
                .noFade()
                .into(mView.getImageView());
    }

    public void saveMeizi(ImageView iv) {
        new AsyncTask<ImageView, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mView.onPrepareSave();
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                mView.onSaveFinish();
                if(aBoolean){
                    mView.onSaveSuccess();
                }else {
                    mView.onSaveFail();
                }
            }

            @Override
            protected Boolean doInBackground(ImageView... params) {
                return executeSaveImpl(params[0]);
            }
        }.execute(iv);

    }

    private boolean executeSaveImpl(ImageView iv){
        try {
            Thread.sleep(2000);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }



    public void onDestroy() {
        mView = null;
    }
}
