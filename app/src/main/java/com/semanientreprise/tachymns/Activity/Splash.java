package com.semanientreprise.tachymns.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.semanientreprise.tachymns.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity implements Animation.AnimationListener {
    @Bind(R.id.splash_img) ImageView iv;
    @Bind(R.id.onefold_txt) TextView oneFold_text;
    @Bind(R.id.semani_txt) TextView semani_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        AnimateView();
    }

    private void AnimateView() {
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.splash_anim);
        oneFold_text.startAnimation(an);
        semani_text.startAnimation(an);
        iv.startAnimation(an);
        an.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        iv.setImageResource(R.drawable.onefold);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent();
        intent.setClass(Splash.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
