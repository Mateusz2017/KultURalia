package pl.edu.ur.kulturalia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Xavizo on 12.05.2016.
 */
public class Adapter extends ArrayAdapter<String>{

    int[] imgs={};
    String[] names={};
    Context c;
    LayoutInflater inflater;

    public Adapter(Context context, String[] names, int[] imgs) {
        super(context, R.layout.model, names);

        this.c = context;
        this.names = names;
        this.imgs = imgs;
    }

    public class ViewHolder{
        TextView donorName;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null);
        }

        final ViewHolder holder = new ViewHolder();
        holder.donorName = (TextView)convertView.findViewById(R.id.donorName);
        holder.img = (ImageView)convertView.findViewById(R.id.img);

        holder.donorName.setText(names[position]);
        holder.img.setImageResource(imgs[position]);

        return convertView;
    }
}
