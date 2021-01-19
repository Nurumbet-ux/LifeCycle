package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView  txtView2,textView2;
    private EditText etText1,etText2,etText3;
    private String set;
    private double int1, int2, int3;
    public static String KEY="key";
    public static String KEYS = "keys";
    private String specific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        txtView2 = findViewById(R.id.arithmetic);
        etText1 = findViewById(R.id.editText1);
        etText2 = findViewById(R.id.editText2);
        etText3 = findViewById(R.id.editText3);
        textView2 = findViewById(R.id.function);
    }

    public void setClick(View view) {
        if (!(etText1.getText().toString().equals("") && etText2.getText().toString().equals("") && etText3.getText().toString().equals(""))) {
            int1 = Integer.parseInt(etText1.getText().toString());
            int2 = Integer.parseInt(etText2.getText().toString());
            int3 = Integer.parseInt(etText3.getText().toString());
        } else {
            Toast.makeText(this, "is empty!!", Toast.LENGTH_SHORT).show();
        }
         set =  Double.valueOf(int1 + int2 + int3).toString();
         specific = String.valueOf(3+4/2);
         txtView2.setText(set);
         textView2.setText(specific);
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,set);
        outState.putString(KEYS,specific);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        set = savedInstanceState.getString(KEY);
        specific = savedInstanceState.getString(KEYS);
        textView2.setText(specific);
        txtView2.setText(set);
    }


}
