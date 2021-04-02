package com.harsh.loan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {

    private Context mContext;
    private final String[]demo;
    private final int[]image;

    public CustomGrid(Context mContext, String[] demo, int[] image) {
        this.mContext = mContext;
        this.demo = demo;
        this.image = image;
    }

    @Override
    public int getCount() {
        return demo.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


//        View grid;
        LayoutInflater layoutInflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//          if (convertView == null) {
//
//            grid = new View(mContext);
//            grid = layoutInflater.inflate(R.layout.raw, null);
//              TextView textView = grid.findViewById(R.id.textview);
//              ImageView imageView = grid.findViewById(R.id.imageview);
//
//              textView.setText(demo[position]);
//              imageView.setImageResource(image[position]);
//        } else {
//            grid = (View) convertView;
//        }
        View inflate = layoutInflater.inflate(R.layout.raw, null);
        TextView textView = inflate.findViewById(R.id.textview);
        ImageView imageView = inflate.findViewById(R.id.imageview);
        textView.setText(""+demo[position]);
        textView.setSelected(true);
        imageView.setImageResource(image[position]);
       return inflate;
    }
}
