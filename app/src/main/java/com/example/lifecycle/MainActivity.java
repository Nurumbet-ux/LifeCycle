package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtView1, txtView2;
    private EditText etText1;
    private EditText etText2;
    private EditText etText3;
    private double int1, int2, int3;
    private String KEY;
    private String KEYS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        txtView1 = findViewById(R.id.Addition);
        txtView2 = findViewById(R.id.Arithmetic);
        etText1 = findViewById(R.id.EditText1);
        etText2 = findViewById(R.id.EditText2);
        etText3 = findViewById(R.id.EditText3);
    }

    public void setClick2(View view) {
        prove();
        txtView2.setText((String) Double.valueOf(int1 + int2 / int3).toString());
    }

    public void prove() {
        String num1 = etText1.getText().toString();
        String num2 = etText2.getText().toString();
        String num3 = etText3.getText().toString();
        if (!(num1.equals("") && num2.equals("") && num3.equals(""))) {
            int1 = Integer.parseInt(num1);
            int2 = Integer.parseInt(num2);
            int3 = Integer.parseInt(num3);

        } else {
            Toast.makeText(this, "is empty!!", Toast.LENGTH_SHORT).show();
        }
    }


    public void setClick(View view) {
        txtView1.setText((String) Double.valueOf(int1 + int2 + int3).toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, txtView1.getText().toString());
        outState.putString(KEYS, txtView2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtView1.setText((String) savedInstanceState.get(KEY));
        txtView2.setText((String) savedInstanceState.get(KEYS));
    }
}
