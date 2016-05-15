package pl.edu.ur.kulturalia;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scena_klubowa_1 extends ListFragment {

    private ListView list ;
    private ArrayAdapter<String> adapter ;
    private TextView bb;

    public Scena_klubowa_1() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DatabaseHelper db = new DatabaseHelper(this.getContext());
        Cursor c = db.getKoncert(1, "Czwartek1");
//        bb = (TextView)  find
        ArrayList<Map<String, String>> events = new ArrayList<>();
        while(true)
        {
            Map<String, String> mapa = new HashMap<String, String>();
            mapa.put("title", c.getString(2));
            mapa.put("content", c.getString(1));
            events.add(mapa);
            if(c.isLast())
                break;
            c.moveToNext();
        }
        SimpleAdapter adapter = new SimpleAdapter(getContext(), events,
                android.R.layout.simple_list_item_2,
                new String[] {"title", "content" },
                new int[] {android.R.id.text1, android.R.id.text2 });
        setListAdapter(adapter);
    }
}