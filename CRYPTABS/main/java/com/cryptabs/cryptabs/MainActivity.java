package com.cryptabs.cryptabs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEncrypt;
    Button btnDecrypt;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEncrypt = (Button) findViewById(R.id.btn_code);
        btnEncrypt.setOnClickListener(this);

        btnDecrypt = (Button) findViewById(R.id.btn_decode);
        btnDecrypt.setOnClickListener(this);

        btnInfo = (Button) findViewById(R.id.btninfo);
        btnInfo.setOnClickListener(this);
    }


@Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_code:
                Intent intente = new Intent(MainActivity.this, EncryptActivity.class);
                startActivity(intente);
                break;
            case R.id.btn_decode:
                Intent intentd = new Intent(MainActivity.this, DecryptActivity.class);
                startActivity(intentd);
                break;
            case R.id.btninfo:
                Intent intenti = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intenti);
                break;

        }
    }
}
