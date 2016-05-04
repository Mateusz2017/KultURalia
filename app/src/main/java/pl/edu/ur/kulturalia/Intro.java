package pl.edu.ur.kulturalia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Intro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide(); //ukrywamy górny pasek tytułu
        setContentView(R.layout.intro);
        Runnable runnable = new Runnable() { //robię nowy wątek który po pewnym czasie wystartuje menu
            @Override
            public void run() {


                try {
                    ImageView logo = (ImageView) findViewById(R.id.logo);
                    ImageView logo_ssur = (ImageView) findViewById(R.id.logo_ssur);
                    ImageView logo_urz = (ImageView) findViewById(R.id.logo_urz);
                    Animation FadeInAnimation = AnimationUtils.loadAnimation(Intro.this, R.anim.fade_logo);
                    Animation FadeInAnimation2 = AnimationUtils.loadAnimation(Intro.this, R.anim.fade_bottom_logo);
                    logo.startAnimation(FadeInAnimation);
                    logo_ssur.startAnimation(FadeInAnimation2);
                    logo_urz.startAnimation(FadeInAnimation2);

                    Thread.sleep(6000); //opóźnienie startu menu w milisekundach
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), Home.class); //1
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //2
                getApplicationContext().startActivity(intent); //3
                //1 2 3 przechodzimy do menu głównego
                finish();
            }

        };
        Thread thread = new Thread(runnable); //4
        thread.start(); //5
        //4 5 robię nowy wątek i startuję go
    }
}
