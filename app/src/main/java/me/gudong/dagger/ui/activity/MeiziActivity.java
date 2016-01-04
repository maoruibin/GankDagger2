package me.gudong.dagger.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dagger.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.gudong.dagger.mvp.model.entity.Gank;
import me.gudong.dagger.mvp.presenters.MeiziPresenter;
import me.gudong.dagger.mvp.views.IMeiziView;
import me.gudong.dagger.reject.components.AppComponent;
import me.gudong.dagger.reject.components.DaggerMeiziActivityComponent;
import me.gudong.dagger.reject.models.MeiziActivityModule;

public class MeiziActivity extends BaseActivity implements IMeiziView {
    private static final String EXTRA_GANK = "GANK";

    @Inject
    MeiziPresenter mPresenter;

    @InjectView(R.id.iv_girl_detail)
    ImageView mIvGirlDetail;
    @InjectView(R.id.pb_loading)
    ProgressBar mPbLoading;
    @InjectView(R.id.rl_loading)
    RelativeLayout mRlLoading;

    public static void gotoMeizi(Activity activity, Gank gank) {
        Intent intent = new Intent(activity, MeiziActivity.class);
        intent.putExtra(EXTRA_GANK, gank);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi);
        ButterKnife.inject(this);
        setTitleBar(true, "妹子");

        mPresenter.attachView(this);
        mPresenter.setContext(this);
        mPresenter.fillData((Gank) getIntent().getSerializableExtra(EXTRA_GANK));
        mPresenter.onCreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_meizi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_save:
                mPresenter.saveMeizi(mIvGirlDetail);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMeiziActivityComponent.builder()
                .meiziActivityModule(new MeiziActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public ImageView getImageView() {
        return mIvGirlDetail;
    }

    @Override
    public void onPrepareSave() {
        mRlLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveSuccess() {
        Toast.makeText(MeiziActivity.this, "save successfully ^_^", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveFail() {
        Toast.makeText(MeiziActivity.this, "save fail *_*", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveFinish() {
        mRlLoading.setVisibility(View.GONE);
    }
}
