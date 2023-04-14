package edu.hanu.hellojapan;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private SwitchCompat switcher;
    private ConstraintLayout mainLayout;

    private ScrollView hiragana;
    private TextView hiraganaText;
    private TextView hiraganaSw;
    private ScrollView katakana;
    private TextView katakanaText;
    private TextView katakanaSw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mainLayout = findViewById(R.id.mainlayout);
        hiragana = findViewById(R.id.hiragana);
        hiraganaText = findViewById(R.id.hiraganaText);
        hiraganaSw = findViewById(R.id.hiragana_sw);

        katakana = findViewById(R.id.katakana);
        katakanaText = findViewById(R.id.katakanaText);
        katakanaSw = findViewById(R.id.katakana_sw);

        Animation flyIn = AnimationUtils.loadAnimation(this, R.anim.fly_in);
        Animation flyOut = AnimationUtils.loadAnimation(this, R.anim.fly_out);

        Animation rflyIn = AnimationUtils.loadAnimation(this, R.anim.fly_in_reverse);
        Animation rflyOut = AnimationUtils.loadAnimation(this, R.anim.fly_out_reverse);



        switcher = findViewById(R.id.switcher);
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked) {

                    mainLayout.setBackgroundColor(getResources().getColor(R.color.Beige));
                    hiraganaText.startAnimation(flyOut);
                    katakanaText.startAnimation(flyIn);
                    hiraganaText.setVisibility(View.GONE);
                    katakanaText.setVisibility(View.VISIBLE);
                    hiragana.animate().scaleX(0.5f).scaleY(0.5f).setDuration(300);
                    hiragana.startAnimation(flyOut);
                    katakana.animate().scaleX(1).scaleY(1).setDuration(300);
                    katakana.startAnimation(flyIn);
                    hiragana.setVisibility(View.GONE);
                    katakana.setVisibility(View.VISIBLE);
                    hiraganaSw.setVisibility(View.VISIBLE);
                    katakanaSw.setVisibility(View.GONE);

                } else {

                    mainLayout.setBackgroundColor(getResources().getColor(R.color.AliceBlue));
                    hiraganaText.startAnimation(rflyIn);
                    katakanaText.startAnimation(rflyOut);
                    hiraganaText.setVisibility(View.VISIBLE);
                    katakanaText.setVisibility(View.GONE);
                    hiragana.animate().scaleX(1).scaleY(1).setDuration(300);
                    hiragana.startAnimation(rflyIn);
                    katakana.animate().scaleX(0.5f).scaleY(0.5f).setDuration(300);
                    katakana.startAnimation(rflyOut);
                    hiragana.setVisibility(View.VISIBLE);
                    katakana.setVisibility(View.GONE);
                    hiraganaSw.setVisibility(View.GONE);
                    katakanaSw.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void onClickSound(View v) {
        String id = getResources().getResourceEntryName(v.getId());//id(String)
        System.out.println(id);
        int resId = getResources().getIdentifier(id, "raw", getPackageName());//id of resource
        if (mp != null ) {
            mp.reset();
        }
        mp = MediaPlayer.create(this, resId);
        mp.start();
    }

    public void onClickSound2(View v) {
        String id = getResources().getResourceEntryName(v.getId()).replace("k_", "h_");//id(String)
        System.out.println(id);
        int resId = getResources().getIdentifier(id, "raw", getPackageName());//id of resource
        if (mp != null ) {
            mp.reset();
        }
        mp = MediaPlayer.create(this, resId);
        mp.start();
    }



}