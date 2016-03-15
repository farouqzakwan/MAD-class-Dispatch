package com.dispatcher.farouq.uiadispatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Item> list = new ArrayList<>();

        //adding items to the list
        Item item1 = new Item(1,"Dcs Office IIUM","Electrical and Engenering Department");
        Item item2 = new Item(2,"Rector Office IIUM","IS office IIUM");
        Item item3 = new Item(3,"IS Office IIUM","Electrical and Engenering Department");
        list.add(item1);
        list.add(item2);
        list.add(item3);

        ListView lv = (ListView)findViewById(R.id.list);
        CustomClass customAdapter = new CustomClass(this,list);
        lv.setAdapter(customAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String textId = list.get(position).id.toString();
                String textName = list.get(position).name;
                String textDescription = list.get(position).Descr;



                Intent intent = new Intent("com.dispatcher.farouq.uiadispatcher.Agreement");
                Bundle extras = new Bundle();


                extras.putString("tag_id","Request id : "+textId);
                extras.putString("tag_name","Pickup Location : "+textName);
                extras.putString("tag_description","Deliver Location : "+textDescription);

                intent.putExtras(extras);
                startActivity(intent);

            }
        });
    }
/*
    private List<Item> createItem(){
        List<Item> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Item it = new Item();
            it.name = "Name"+i;
            it.Descr = "Descr"+i;
            arrayList.add(it);
        }

        return arrayList;
    }
 */
}
