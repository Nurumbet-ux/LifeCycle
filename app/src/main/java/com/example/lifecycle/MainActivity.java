package com.example.lifecycle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView  txtView2;
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
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,set);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        set = savedInstanceState.getString(KEY);
        txtView2.setText(set);
    }


}
