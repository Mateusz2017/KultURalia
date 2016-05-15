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
public class Organizatorzy extends AppCompatActivity {

    ListView list;

    String[] names ={"Uniwersytet Rzeszowski", "Samorząd Studencki Uniwersytetu Rzeszowskiego"};
    int[] images = {R.drawable.logourz, R.drawable.logossur}; //wstawia logo sponsora

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
