package com.dispatcher.farouq.uiadispatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Agreement extends AppCompatActivity {
    private String TAG = "UIAdispatch";
    private String mode;
    private String pickHrs = "pick in 1 hours";
    private String deliverHrs = "deliver in 1 hours";
    private String id;
    private String pickup;
    private String deliver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        TextView txtreq = (TextView)findViewById(R.id.txtViewReqid);
        NumberPicker noPickPickup = (NumberPicker)findViewById(R.id.noPickerPickup);
        NumberPicker noPickDeliver = (NumberPicker)findViewById(R.id.noPickerDeliver);

        noPickPickup.setMinValue(1);
        noPickPickup.setMaxValue(5);
        noPickPickup.setWrapSelectorWheel(false);

        noPickPickup.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                pickHrs = "pick in " + newVal + " hours";
            }
        });

        noPickDeliver.setMinValue(1);
        noPickDeliver.setMaxValue(5);
        noPickDeliver.setWrapSelectorWheel(false);

        noPickDeliver.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                deliverHrs = "deliver in "+newVal+" hours";
            }
        });

        id = (String)extras.get("tag_id");
        pickup = (String)extras.get("tag_name");
        deliver = (String)extras.get("tag_description");

        Toast.makeText(Agreement.this,"id : "+id+" pickup : "+pickup+" deliver : "+deliver,Toast.LENGTH_LONG).show();

       txtreq.setText(id);
    }

    public void DispatchAgreement(View view){
        Intent emailing = new Intent("com.dispatcher.farouq.uiadispatcher.Emailing");
        Bundle extras = new Bundle();
        extras.putString("tag_id",id);
        extras.putString("tag_pickup",pickup);
        extras.putString("tag_deliver",deliver);
        extras.putString("tag_pickup_time",pickHrs);
        extras.putString("tag_deliver_time",deliverHrs);
        extras.putString("tag_mode",mode);
        emailing.putExtras(extras);
        startActivity(emailing);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioFoot:
                if (checked) {
                    Log.d(TAG, "onRadioButtonClicked: foot");
                    mode = "by foot";
                }
                    break;
            case R.id.radioMoto:
                if (checked)
                {
                    Log.d(TAG, "onRadioButtonClicked: Moto");
                    mode = "by motorcycle";
                }
                    break;
            case R.id.radioCar:
                    if (checked)
                    {
                        Log.d(TAG, "onRadioButtonClicked: car");
                        mode = "by car";
                    }
                        break;
        }
    }
}
