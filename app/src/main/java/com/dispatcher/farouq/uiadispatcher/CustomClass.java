package com.dispatcher.farouq.uiadispatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by epic on 14/03/2016.
 */
public class CustomClass extends BaseAdapter {
    private Context context;
    private List<Item> list;

    public CustomClass(Context context,List<Item> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        //return 0 if list is null else return size of the list
        return list == null? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        //return null if list is null else get position of id
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list == null ? null : list.get(position).hashCode();
    }

    //the main important part to inflate the view into the listview..
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        TextHolder th;

        if(v == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.listlayout,null);

            TextView id = (TextView)v.findViewById(R.id.dispatchid);
            TextView name = (TextView)v.findViewById(R.id.name);
            TextView descr = (TextView)v.findViewById(R.id.descr);

            th = new TextHolder();
            th.idTextView = id;
            th.nameTextView = name;
            th.descrTextView = descr;

            v.setTag(th);
        }else{
            th = (TextHolder)v.getTag();
        }
            th.idTextView.setText("Request id : "+list.get(position).id);
            th.nameTextView.setText("Pickup Location : "+list.get(position).name);
            th.descrTextView.setText("Deliver Location : "+list.get(position).Descr);

        return v;
    }

    static class TextHolder{
        TextView idTextView;
        TextView nameTextView;
        TextView descrTextView;
    }
}
