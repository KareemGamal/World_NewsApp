package el1000mile.tpd2.b5twa.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KeMoOoOoO on 9/17/2017.
 */

public class ListAdapter extends BaseAdapter {

    ArrayList<String> SourceNames = new ArrayList<>();
    ArrayList<Integer> SourceImage = new ArrayList<>();
    Context c ;

    public ListAdapter(ArrayList<String> sourceNames, ArrayList<Integer> sourceImage, Context c) {
        SourceNames = sourceNames;
        SourceImage = sourceImage;
        this.c = c;
    }

    @Override
    public int getCount() {
        return SourceImage.size();
    }

    @Override
    public Object getItem(int i) {
        return SourceImage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
        {
           view = inflater.inflate(R.layout.model , null);

        }
        TextView name = (TextView)view.findViewById(R.id.textView);
        ImageView image = (ImageView)view.findViewById(R.id.imageView);

        name.setText(SourceNames.get(i));
        image.setImageResource(SourceImage.get(i));

        return view;
    }
}
