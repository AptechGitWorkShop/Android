package com.example.myapp22_sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_un,editText_pass;
    Button btn;
    SharedPreferences sharedPreferences;
    private  static  final String Sp_Name= "mypref";
    private static  final String KEY_USERNAME= "un";
    private static  final String KEY_Password= "pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_un = findViewById(R.id.un);
        editText_pass = findViewById(R.id.pwd);
        btn= findViewById(R.id.btnsubmit);
        sharedPreferences = getSharedPreferences(Sp_Name,MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText_un.getText().toString();
                String password = editText_pass.getText().toString();
                if(username.equals("marium") && password.equals("123"))
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME,username);
                    editor.putString(KEY_Password,password);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}