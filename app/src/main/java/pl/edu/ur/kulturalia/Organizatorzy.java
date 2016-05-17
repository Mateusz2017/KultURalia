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

    String[] names ={"Uniwersytet Rzeszowski", "Samorząd Studencki Uniwersytetu Rzeszowskiego",
    "Stowarzyszenie Studentów i Absolwentów UR", "VI Juwenalia Podkarpackie", "Karolina Sobala - Główny Koordynator", "Justyna Ogrodzka - Koordynator ds. wydarzeń kulturalnych", "Robert Karnaś - Koordynator ds. wydarzeń sportowych",
    "Karolina Borowiec - Koordynator ds. korowodu", "Marta Guziakiewicz - Rzecznik Prasowy SSUR", "Kamila Sikorska - Koordynator konkursu Student ma Talent", "Kamil Trojnar - Koordynator ds. zespołów i sceny", "Damian Strojny - Kierownik biura",
            "Paulina Zwierzyńska - Koordynator VIP ROOM", "Piotr Moroch - Koordynator ds. bezpieczeństwa"};
    int[] images = {R.drawable.logourz, R.drawable.logossur, R.drawable.o0, R.drawable.o01, R.drawable.o1, R.drawable.o2,
    R.drawable.o3, R.drawable.o4, R.drawable.o5, R.drawable.o6, R.drawable.o7, R.drawable.o8, R.drawable.o9, R.drawable.o10}; //wstawia logo sponsora

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
