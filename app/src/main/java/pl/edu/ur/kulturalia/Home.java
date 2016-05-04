package pl.edu.ur.kulturalia;

import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class Home extends AppCompatActivity {

    Button fanpage;
    Button autorzy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fanpage = (Button) findViewById(R.id.button5);
        fanpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/kultURaliaUR"));
                    v.getContext().startActivity(Intent.createChooser(intent, "Wybór przeglądarki"));
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        autorzy = (Button) findViewById(R.id.button4);
        autorzy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Autorzy.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
