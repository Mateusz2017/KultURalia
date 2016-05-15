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
public class Sponsorzy extends AppCompatActivity {

    ListView list;

    String[] names ={"Bank Zachodni WBK", "PBSbank", "Bank Pekao", "Beach Bar - lychee", "Zacisze - Hotel i Restauracja", "Agnieszka Rajtar make up artist", "Kino Helios", "ICF karting", "CAR-RENTAL.pl", "Blue adventures - centrum nurkowe", "BLACK", "PERŁA", "Prezydent Miasta Rzeszów", "RzJuwenalia", "SSiA", "Szkoła Tańca StreetLife", "SYLEVECO", "VI Juwenalia Podkarpackie", "VIANEK" };
    int[] images = {R.drawable.s23, R.drawable.s24, R.drawable.s25, R.drawable.s26, R.drawable.s27, R.drawable.s28, R.drawable.s29, R.drawable.s30, R.drawable.s31, R.drawable.s32, R.drawable.s33, R.drawable.s34, R.drawable.s35, R.drawable.s36, R.drawable.s37, R.drawable.s38, R.drawable.s39, R.drawable.s40, R.drawable.s41, R.drawable.s42}; //wstawia logo sponsora

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_sponsorzy);

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
