package pl.edu.ur.kulturalia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Xavizo on 12.05.2016.
 */
public class MainDonors extends AppCompatActivity{
    Button organizatorzy;
    Button sponsorzy;
    Button patronatyHonorowe;
    Button patroniMedialni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors);

        organizatorzy = (Button) findViewById(R.id.button1);
        organizatorzy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Organizatorzy.class);
                v.getContext().startActivity(intent);
            }
        });

        sponsorzy = (Button) findViewById(R.id.button2);
        sponsorzy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Sponsorzy.class);
                v.getContext().startActivity(intent);
            }
        });
        patronatyHonorowe = (Button) findViewById(R.id.button3);
        patronatyHonorowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Patronaty_honorowe.class);
                v.getContext().startActivity(intent);
            }
        });
        patroniMedialni = (Button) findViewById(R.id.button4);
        patroniMedialni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Patroni_medialni.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
