package com.cryptabs.cryptabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecryptActivity extends Activity {

    private Button decr;
    private EditText input;
    private TextView outpu;
    private EditText kee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decrypt_activity);

        decr = (Button) findViewById(R.id.Decrypt);
        input = (EditText) findViewById(R.id.input);
        outpu = (TextView) findViewById(R.id.view);
        kee = (EditText) findViewById(R.id.kee);

        decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int keyint = Integer.parseInt(kee.getText().toString());
                long globalnt = Long.parseLong(input.getText().toString());
                outpu.setText(Decrypt(keyint, globalnt));
            }
        });
    }

    public String Decrypt(int keyint, long h) {
        int n1, n2, n3, n4, n5, n6;
        n1 = (int) Math.floor(h/1000/1000/1000/1000/1000)-keyint;
        n2 = (int) Math.floor(h/1000/1000/1000/1000%1000)-keyint;
        n3 = (int) Math.floor(h/1000/1000/1000%1000%1000)-keyint;
        n4 = (int) Math.floor(h/1000/1000%1000%1000%1000)-keyint;
        n5 = (int) Math.floor(h/1000%1000%1000%1000%1000)-keyint;
        n6 = (int) Math.floor(h%1000%1000%1000%1000%1000)-keyint;
        String dd = n1 + "\n" + n2 + "\n" + n3 + "\n" + n4 + "\n" + n5 + "\n" + n6;
        return dd;
    }
}
