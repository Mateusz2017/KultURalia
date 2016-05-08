package pl.edu.ur.kulturalia;

//import static com.example.mateusz.wydarzenia.DatabaseHelper;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Harmonogram_1 extends Fragment {
    EditText  eopis, eczas;
    public Harmonogram_1() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        DatabaseHelper db=new DatabaseHelper(getActivity());
        Cursor c= db.getKoncert(1,"Czwartek");
//        eczas1 = c.getString(1);
//       eopis= c.getString(2);
//        eczas = (TextView)  find
//        eopis = (EditText) FindViewById(R.id.czas);
        return inflater.inflate(R.layout.fragment_harmonogram_1, container, false);
    }

}
