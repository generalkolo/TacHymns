package com.semanientreprise.tachymns.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.llollox.androidtoggleswitch.widgets.ToggleSwitch;
import com.semanientreprise.tachymns.data.DataFeeder;
import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.EnglishHymnFragment;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HymnDetails extends AppCompatActivity implements ToggleSwitch.OnChangeListener {

    @BindView(R.id.hymnNumberTitle) TextView hymnNumberTitle;
    @BindView(R.id.hymnScripture) TextView hymnScripture;
    @BindView(R.id.hymnStanzas) TextView hymnStanzas;
    @BindView(R.id.mToolbar) Toolbar hymnDetailsToolbar;
    @BindView(R.id.backButton) ImageView backButton;
    @BindView(R.id.forwardButton) ImageView forwardButton;
    @BindView(R.id.langToggleSwitch) ToggleSwitch hymnDetailsToggleSwitch;
    private int textProgress = 18;
    private final int textDefault = 18;
    private String hymnStanzaAndChorusReceived = "";
    private String hymnScriptureReceived = "";
    private String hymnNumberTitleReceived = "";
    private int positionIndicator, positionClicked;
    private List<SongsGAndS> englishDataReceived, yorubaDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hymn_details_activity);
        ButterKnife.bind(this);

        setSupportActionBar(hymnDetailsToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("TAC HYMNS");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        getSentDetails();

        setToggleSwitchCheckPosition(getIntent().getStringExtra(EnglishHymnFragment.HYMN_SELECTION));
    }

    private void getSentDetails() {
        positionClicked = getIntent().getIntExtra(EnglishHymnFragment.POSITION_SELECTED, 0);

        englishDataReceived = DataFeeder.getEnglishData();
        yorubaDataReceived = DataFeeder.getYorubaData();
    }

    @OnClick({R.id.backButton, R.id.forwardButton})
    public void onViewClicked(View view) {
                /*idea behind the execution is i reduce the value of the positionClicked by one and
                check if the answer is lower than 0, if yes then send a toast telling the user that he has reached the last
                hymn we have and vice versa for the increase or forward button clicked*/
        switch (view.getId()) {
            case R.id.backButton:
                if (--positionClicked < 0) {
                    showToast("Last Hymn Reached");
                    positionClicked++;
                } else {
                    changeHymn(positionIndicator, 1);
                }
                break;
            case R.id.forwardButton:
                if (++positionClicked >= englishDataReceived.size()) {
                    showToast("Last Hymn Reached");
                    positionClicked--;
                }
                else {
                    changeHymn(positionIndicator, 2);
                    switch (positionIndicator) {
                        case 0:
                            changeHymnForwardBackward(englishDataReceived, positionClicked, 2);
                            break;
                        case 1:
                            changeHymnForwardBackward(yorubaDataReceived, positionClicked, 2);
                            break;
                        case 2:
                            changeHymnForwardBackward(englishDataReceived, positionClicked, 2);
                            break;
                        case 3:
                            changeHymnForwardBackward(englishDataReceived, positionClicked, 2);
                            break;
                    }
                }
                break;
        }
    }

    private void changeHymn(int positionIndicator, int sentFrom) {
        switch (sentFrom) {
            case 1:
                switch (positionIndicator) {
                    case 0:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                    case 1:
                        changeHymnForwardBackward(yorubaDataReceived, positionClicked, sentFrom);
                        break;
                    case 2:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                    case 3:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                }
                break;
            case 2:
                switch (positionIndicator) {
                    case 0:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                    case 1:
                        changeHymnForwardBackward(yorubaDataReceived, positionClicked, sentFrom);
                        break;
                    case 2:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                    case 3:
                        changeHymnForwardBackward(englishDataReceived, positionClicked, sentFrom);
                        break;
                }
                break;
        }
    }

    private void changeHymnForwardBackward(List<SongsGAndS> dataReceived, int positionClicked, int indicator) {
        //Key: 1 is the indicator for the backward button clicked
        //while 2 is the indicator for the forward button clicked
        switch (indicator) {
            case 1:
                inflateViews(dataReceived, positionClicked);
                break;
            case 2:
                inflateViews(dataReceived, positionClicked);
                break;
        }
    }

    private void setToggleSwitchCheckPosition(String hymnClicker) {
        //Set the default toggle switch position based on what language the hymn is clicked from
        switch (hymnClicker) {
            case "ENGLISH_SELECTION":
                positionIndicator = 0;
                hymnDetailsToggleSwitch.setCheckedPosition(positionIndicator);
                inflateViews(englishDataReceived, positionClicked);
                break;
            case "YORUBA_SELECTION":
                positionIndicator = 1;
                hymnDetailsToggleSwitch.setCheckedPosition(positionIndicator);
                inflateViews(yorubaDataReceived, positionClicked);
                break;
            case "HAUSA_SELECTION":
                positionIndicator = 2;
                hymnDetailsToggleSwitch.setCheckedPosition(positionIndicator);
                break;
            case "IGBO_SELECTION":
                positionIndicator = 3;
                hymnDetailsToggleSwitch.setCheckedPosition(positionIndicator);
                break;
        }
        hymnDetailsToggleSwitch.setOnChangeListener(this);
    }

    private void inflateViews(List<SongsGAndS> dataReceived, int positionClicked) {
        hymnStanzaAndChorusReceived = dataReceived.get(positionClicked).SongStanzasAndChorus();
        hymnNumberTitleReceived = dataReceived.get(positionClicked).getHymnTitle();
        hymnScriptureReceived = dataReceived.get(positionClicked).getHymnScripture();

        //Get all the hymn attribute and populate the Views
        hymnNumberTitle.setText(hymnNumberTitleReceived);
        hymnScripture.setText(hymnScriptureReceived);
        hymnStanzas.setText(hymnStanzaAndChorusReceived);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hymn_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                shareHymn(hymnStanzaAndChorusReceived, hymnNumberTitleReceived, hymnScriptureReceived);
                break;
            case R.id.action_textSize:
                showTextSizeDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showTextSizeDialog() {
        final Dialog dialog = new Dialog(this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.textsize_dialog);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(R.color.white);
        dialog.setCancelable(true);

        final TextView textSizeIndicator = dialog.getWindow().findViewById(R.id.tv_textSizeIndicator);
        SeekBar textSizeSeekBar = dialog.getWindow().findViewById(R.id.textSizeSeeker);

        textSizeSeekBar.setProgress(textProgress);
        textSizeIndicator.setText(String.valueOf(textProgress));

        textSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < textDefault) {
                    seekBar.setProgress(textDefault);
                } else {
                    textSizeIndicator.setText(String.valueOf(progress));
                    hymnStanzas.setTextSize(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textProgress = seekBar.getProgress();
                textSizeIndicator.setText(String.valueOf(textProgress));
            }
        });

        dialog.show();
    }

    private void shareHymn(String hymnStanzaAndChorusReceived, String hymnNumberTitleReceived, String hymnScriptureReceived) {
        StringBuilder textToShare = new StringBuilder();
        textToShare.append(hymnNumberTitleReceived + "\n" + hymnScriptureReceived + "\n" + hymnStanzaAndChorusReceived);
        textToShare.append(" - Shared from TAC WAZOBIA Hymn");

        //Method to create the sharing text for the hymn clicked
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "SHARE Hymn");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, textToShare.toString());
        startActivity(Intent.createChooser(sharingIntent, "Share Via: "));
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                positionIndicator = 0;
                inflateViews(englishDataReceived, positionClicked);
                break;
            case 1:
                positionIndicator = 1;
                inflateViews(yorubaDataReceived, positionClicked);
                break;
            case 2:
                positionIndicator = 2;
                showToast("Hausa Has been clicked");
                break;
            case 3:
                positionIndicator = 3;
                showToast("Igbo Has been clicked");
                break;
        }
    }

    private void showToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}