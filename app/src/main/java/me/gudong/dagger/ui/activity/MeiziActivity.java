package me.gudong.dagger.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dagger.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.gudong.dagger.reject.components.AppComponent;

public class MeiziActivity extends BaseActivity {
    private static final String EXTRA_URL = "URL";
    @InjectView(R.id.iv_girl_detail)
    ImageView mIvGirlDetail;

    public static void gotoMeizi(Activity activity,String url){
        Intent intent = new Intent(activity,MeiziActivity.class);
        intent.putExtra(EXTRA_URL,url);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi);
        ButterKnife.inject(this);
        initTitleBar(true,"妹子");
//        Picasso.with(this).load(url).into(mIvGirlDetail);
        Picasso.with(this)
                .load(getIntent().getStringExtra(EXTRA_URL))
                .noFade()
                .into(mIvGirlDetail);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
