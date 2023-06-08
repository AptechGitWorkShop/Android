package com.example.myapp22_sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textView,textView_pass ;
    SharedPreferences sharedPreferences;
    private  static  final String Sp_Name= "mypref";
    private static  final String KEY_USERNAME= "un";
    private static  final String KEY_Password= "pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = findViewById(R.id.output_un);
        textView_pass = findViewById(R.id.output_pass);
        sharedPreferences = getSharedPreferences(Sp_Name,MODE_PRIVATE);
      String Username=  sharedPreferences.getString(KEY_USERNAME,null);
        String mypass=  sharedPreferences.getString(KEY_Password,null);
        if(Username!=null)
        {
            textView.setText(Username);
            textView_pass.setText(mypass);
        }

    }
}