package pl.edu.ur.kulturalia;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;




public class Intro extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        //Notyfikacja:
        NotificationCompat.Builder mBuilder;
        mBuilder = new NotificationCompat.Builder(getApplicationContext());
        mBuilder.setSmallIcon(R.drawable.ic_ur);
        mBuilder.setContentTitle("KultURalia");
        mBuilder.setContentText("Zobacz co przygotowaliśmy dzisiaj dla Ciebie!");
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.logourz);
        mBuilder.setLargeIcon(largeIcon);
        mBuilder.addAction(R.drawable.ic_kulturalia,"Zobacz więcej", pIntent);


        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId,mBuilder.build());
        //Powiadomienie, które pojawia się po włączeniu aplikacji.

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

                    Thread.sleep(4500); //opóźnienie startu menu w milisekundach
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //1
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
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
        finish();
        return true;
    }

}
