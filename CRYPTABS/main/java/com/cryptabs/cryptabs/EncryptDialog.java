package com.cryptabs.cryptabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EncryptDialog extends AppCompatActivity{

    private EditText n1;
    private EditText n2;
    private EditText n3;
    private EditText n4;
    private EditText n5;
    private EditText n6;
    private TextView key;
    private Button save;
    private Button exit;
    Intent intent = new Intent(this, EncryptActivity.class);
    public int k = (int) (Math.random()*920);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypt_dialog);

        if (k<100) {
            while (k<100) {
                k = (int) (Math.random()*920);
            }
        }

        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        n3 = (EditText) findViewById(R.id.n3);
        n4 = (EditText) findViewById(R.id.n4);
        n5 = (EditText) findViewById(R.id.n5);
        n6 = (EditText) findViewById(R.id.n6);
        key =(TextView) findViewById(R.id.key);
        key.setText(Integer.toString(k));
        save = (Button) findViewById(R.id.btnsave);
        exit = (Button) findViewById(R.id.btnexit);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ns1 = n1.getText().toString();
                String ns2 = n2.getText().toString();
                String ns3 = n3.getText().toString();
                String ns4 = n4.getText().toString();
                String ns5 = n5.getText().toString();
                String ns6 = n6.getText().toString();
                intent.putExtra("array", EnThis(ns1, ns2, ns3, ns4, ns5, ns6, k));
                intent.putExtra("key", k);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static int[] EnThis(String n1, String n2, String n3, String n4, String n5, String n6, int key){
        int[] a = new int[6];
        a[0] = Integer.parseInt(n1) + key;
        a[1] = Integer.parseInt(n2) + key;
        a[2] = Integer.parseInt(n3) + key;
        a[3] = Integer.parseInt(n4) + key;
        a[4] = Integer.parseInt(n5) + key;
        a[5] = Integer.parseInt(n6) + key;

        return a;
    }
}


