package pl.edu.ur.kulturalia;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Intro extends AppCompatActivity {

    /*CountDownTimer cTimer = null;

    public void startLogoTimer() {

        cTimer = new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {

                logo.setAlpha(millisUntilFinished/50000f);
            }
            public void onFinish() {
            }
        };
        cTimer.start();
    }
    public void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();*/

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide(); //ukrywamy górny pasek tytułu
        setContentView(R.layout.intro);
        Runnable runnable = new Runnable() { //robię nowy wątek który po pewnym czasie wystartuje menu
            @Override
            public void run() {


                try {
                    Thread.sleep(5000); //opóźnienie startu menu w milisekundach
                    ImageView logo = (ImageView) findViewById(R.id.logo);
                    Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                    logo.startAnimation(animation1);
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), Home.class); //1
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //2
                getApplicationContext().startActivity(intent); //3
                //1 2 3 przechodzimy do menu głównego
            }
        };
        Thread thread = new Thread(runnable); //4
        thread.start(); //5
        //4 5 robię nowy wątek i startuję go
    }
}
