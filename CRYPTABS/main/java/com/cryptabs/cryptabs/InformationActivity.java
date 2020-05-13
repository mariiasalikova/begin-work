package com.cryptabs.cryptabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends Activity {
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inform_activity);
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.information);
    }
}
