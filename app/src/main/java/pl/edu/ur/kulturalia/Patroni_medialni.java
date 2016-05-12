package pl.edu.ur.kulturalia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Xavizo on 12.05.2016.
 */
public class Patroni_medialni extends AppCompatActivity {

    ListView list;

    String[] names ={"Radio FeniksFM", "RESinet.pl", "wydarzysie.pl", "Day&Night", "disco-polo.info",
            "hej.rzeszow.pl", "imprezy.rzeszow.pl", "kulturaisztuka.pl", "Kultura w Rzeszowie",
            "Radio Via", "mlodzi.rzeszow.pl", "koncertywrzeszowie.pl", "Polskie Radio RZESZÓW",
            "Super Nowości 24", "TVP3 Rzeszów", "radioWawa"};
    int[] images = {R.drawable.m06, R.drawable.m07, R.drawable.m08, R.drawable.m09, R.drawable.m10,
            R.drawable.m11, R.drawable.m12, R.drawable.m13, R.drawable.m14, R.drawable.m15,
            R.drawable.m16, R.drawable.m17, R.drawable.m18, R.drawable.m19, R.drawable.m20, R.drawable.m21 }; //wstawia logo sponsora


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_medialni);

        list = (ListView) findViewById(R.id.listView);

        Adapter adapter = new Adapter(this, names, images);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Toast.makeText(getApplicationContext(), names[pos], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
