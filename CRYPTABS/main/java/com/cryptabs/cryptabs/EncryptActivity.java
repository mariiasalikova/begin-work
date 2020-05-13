package com.cryptabs.cryptabs;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EncryptActivity extends AppCompatActivity {

    private Button button;
    private Button show;
    private Button gob;
    private TextView output;
    private Button copy;
    int[] mass = new int[6];
    int keye;
    Context context = this;

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypt_activity);
        button = (Button) findViewById(R.id.button);
        gob = (Button) findViewById(R.id.goback);
        show = (Button) findViewById(R.id.show);
        output = (TextView) findViewById(R.id.outp);
        copy = (Button) findViewById(R.id.copy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentea = new Intent(EncryptActivity.this, EncryptDialog.class);
                startActivityForResult(intentea, 1);
            }
        });

        gob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mass.length; i++) {
                    output.setText(output.getText() + "" + mass[i]);
                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", output.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                mass = data.getIntArrayExtra("array");
                keye = data.getIntExtra("key", 0);
                break;
        }
    }}