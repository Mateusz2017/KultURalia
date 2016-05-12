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
public class Patronaty_honorowe extends AppCompatActivity {

    ListView list;

    String[] names ={"Rektor Uniwersytetu Rzeszowskiego", "Patronat Marszałka Województwa Podkarpackiego Władysława Ortyla", "Patronat Wojewody Podkarpackiego - Ewy Leniart", "Patronat Starosty Powiatu Rzeszowskiego - Józef Jodłowski", "Patronat Przewodniczącego Sejmiku Województwa Podkarpackiego - Jerzego Cyprysia"};
    int[] images = {R.drawable.h01, R.drawable.h02, R.drawable.h03, R.drawable.h04, R.drawable.h05}; //wstawia logo sponsora

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_organizatorzy);

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
