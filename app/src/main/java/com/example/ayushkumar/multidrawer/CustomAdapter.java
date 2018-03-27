package com.example.ayushkumar.multidrawer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ayushkumar on 19/02/18.
 */

public class CustomAdapter extends BaseAdapter
{
    String result [] ;
    Context con ;
    int img[];
    private static LayoutInflater inflater = null ;

    public CustomAdapter(String[] result, Context con, int[] img)
    {
        this.result = result;
        this.con = con;
        this.img = img;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        final holder hld = new holder();
        View rowView;
        rowView = inflater.inflate(R.layout.gdmain, null);
        hld.tv = (TextView) rowView.findViewById(R.id.txt1);
        hld.iv = (ImageView) rowView.findViewById(R.id.img1);
        hld.tv.setText(result[i]);
        hld.iv.setImageResource(img[i]);
        hld.tv.setTextColor(Color.BLUE);
        return rowView;
    }

    public class holder
    {
        TextView tv;
        ImageView iv ;
    }
}
