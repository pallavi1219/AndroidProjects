package com.example.mbhusari.foofish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Switch;

import java.util.HashMap;
import java.util.Map;

public class FooFishActivity extends AppCompatActivity {
    boolean isFeederSwitchOn = false;
    boolean isCameraSwitchOn = false;

    String cameraInterval = "-1";
    String feederInterval = "-1";

    String previousCameraInterval = "-1";
    String previousFeederInterval = "-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo_fish);


        final Spinner feederSpinner=(Spinner) findViewById(R.id.spinner2);
        final Spinner livePictureSpinner=(Spinner) findViewById(R.id.spinner3);

        Switch feederSwitch = (Switch) findViewById(R.id.switch2);
        Switch livePictureSwitch = (Switch) findViewById(R.id.switch3);

        feederSpinner.setEnabled(false);
        livePictureSpinner.setEnabled(false);

        setSettingValues(feederInterval, cameraInterval);

        feederSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {

                if(feederSpinner.isEnabled()) {
                    feederInterval = parent.getItemAtPosition(pos).toString();
                    setSettingValues(feederInterval, cameraInterval);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        livePictureSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                if (livePictureSpinner.isEnabled()) {
                    cameraInterval = parent.getItemAtPosition(pos).toString();
                    setSettingValues(feederInterval, cameraInterval);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        feederSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked) {
                    isFeederSwitchOn = true;
                    feederSpinner.setEnabled(true);
                    feederInterval = previousFeederInterval;
                    setSettingValues(feederInterval, cameraInterval);
                } else {
                    isFeederSwitchOn = false;
                    feederSpinner.setEnabled(false);
                    previousFeederInterval = feederInterval;
                    feederInterval = "-1";
                    setSettingValues(feederInterval, cameraInterval);
                }
            }
        });

        livePictureSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked) {
                    isFeederSwitchOn = true;
                    livePictureSpinner.setEnabled(true);
                    cameraInterval = previousCameraInterval;
                    setSettingValues(feederInterval, cameraInterval);
                } else {
                    isFeederSwitchOn = false;
                    livePictureSpinner.setEnabled(false);
                    previousCameraInterval = cameraInterval;
                    cameraInterval = "-1";
                    setSettingValues(feederInterval, cameraInterval);
                }
            }
        });


    }


    void setSettingValues(String feederInterval, String livePictureInterval) {
        Map<String, String> postData = new HashMap<>();

        postData.put("motorInterval", feederInterval);
        postData.put("cameraScreenshotInterval", livePictureInterval);
        HttpPostAsyncTask task = new HttpPostAsyncTask(postData);
        task.execute("http://foofish1-env.us-east-1.elasticbeanstalk.com/webapi/myresource/setDeviceConfig");

    }
}
