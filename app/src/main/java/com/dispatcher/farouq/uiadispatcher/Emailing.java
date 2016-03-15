package com.dispatcher.farouq.uiadispatcher;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Emailing extends AppCompatActivity {
    private String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailing);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        String id = (String)extras.get("tag_id");
        String pickup = (String)extras.get("tag_pickup");
        String deliver = (String)extras.get("tag_deliver");
        String timePickup = (String)extras.get("tag_pickup_time");
        String timeDeliver = (String)extras.get("tag_deliver_time");
        String modeDispatch = (String)extras.get("tag_mode");

        message = id+", "+pickup+", "+timePickup+", "+deliver+", "+timeDeliver+" "+modeDispatch;

        TextView txtDisplay = (TextView)findViewById(R.id.txtDisp);
        txtDisplay.setText(message);
    }

    public void onEmailDispatchMaster(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Dispatch apps");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setClassName("com.android.email","com.android.email.activity.MessageCompose");
        try{startActivity(emailIntent);}catch (ActivityNotFoundException e){e.printStackTrace();}
    }
}
