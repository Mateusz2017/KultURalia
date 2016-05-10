package pl.edu.ur.kulturalia;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Harmonogram_2 extends Fragment {


   private TextView ekoncert1, ekoncert2, ekoncert3, ekoncert4, ekoncert5, ekoncert6, ekoncert7;

    public Harmonogram_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_harmonogram_2, container, false);
        DatabaseHelper db = new DatabaseHelper(this.getContext());
        Cursor c = db.getKoncert(1, "Piatek");
        ekoncert1 = (TextView) view.findViewById(R.id.koncert_p1);
        ekoncert2 = (TextView) view.findViewById(R.id.koncert_p2);
        ekoncert3 = (TextView) view.findViewById(R.id.koncert_p3);
        ekoncert4 = (TextView) view.findViewById(R.id.koncert_p4);
        ekoncert5 = (TextView) view.findViewById(R.id.koncert_p5);
        ekoncert6 = (TextView) view.findViewById(R.id.koncert_p6);
        ekoncert7 = (TextView) view.findViewById(R.id.koncert_p7);

        ekoncert1.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert2.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert3.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert4.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert5.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert6.setText(c.getString(2) + " " + c.getString(1));
        c.moveToNext();
        ekoncert7.setText(c.getString(2) + " " + c.getString(1));

        return  view;
    }

}
