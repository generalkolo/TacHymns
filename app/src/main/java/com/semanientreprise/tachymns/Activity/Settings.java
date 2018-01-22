package com.semanientreprise.tachymns.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.semanientreprise.tachymns.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Settings extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Bind(R.id.mToolbar) Toolbar settingsToolbar;
    @Bind(R.id.display_text_sb) SeekBar displayTextSeekBar;
    @Bind(R.id.display_text_real) TextView displayText;
    @Bind(R.id.confirm_close_cb) CheckBox checkBox;
    @Bind(R.id.white_bk) ImageView white_ground;
    @Bind(R.id.black_bk) ImageView black_ground;
    @Bind(R.id.confirm_auto_scroll) CheckBox confirmAutoScroll;
    @Bind(R.id.settings_cont) RelativeLayout st_container;

    final private int textProgress = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        checkBox.setOnClickListener(this);

        displayTextSeekBar.setProgress(textProgress);
        displayText.setTextSize(textProgress);
        displayTextSeekBar.setOnSeekBarChangeListener(this);


        black_ground.setOnClickListener(this);
        white_ground.setOnClickListener(this);

        setSupportActionBar(settingsToolbar);

        getSupportActionBar().setTitle("TAC HYMNS");
        getSupportActionBar().setLogo(R.drawable.ic_music_note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about_us:
                showAchievers();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Method that displays Achievers information
    private void showAchievers() {
        final Dialog dialog = new Dialog(Settings.this, R.style.DialogSlideAnimCart);
        dialog.setContentView(R.layout.about_us_layout);
        dialog.setTitle("Achievers Solutions Inc");
        dialog.getWindow().setGravity(Gravity.CENTER);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        /*if(((CheckBox)v).isChecked()){
            //Save value for loading
            //Save into sharedPreference and check value to carry out the operation to confirm close
        }*/

        //A switch statement that changes the color of the background and also the textViews colors
        switch (v.getId()) {

            case R.id.white_bk:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;

            case R.id.black_bk:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (progress < textProgress) {
            Toast.makeText(this, "Text display cannot be less than this", Toast.LENGTH_SHORT).show();
            seekBar.setProgress(textProgress);
        } else {
            displayText.setTextSize(progress);
            //Set the size of the song textView
//            Song_Fragment.getSong_txt().setTextSize(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
