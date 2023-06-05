package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtemail,txtpass;
    Button btn;
    private RequestQueue rq;
    private StringRequest request;

    //10.0.2.2 localhost default//
//    static  final  String url="http://10.0.3.94/user_control.php";
    static  final  String url="http://10.0.2.2:82/user_control.php";
//   static  final  String url="https://hawari.pk/user_control.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = (EditText)findViewById(R.id.txtemail);
        txtpass = (EditText) findViewById(R.id.txtpass);
        btn = (Button) findViewById(R.id.button);

        rq= Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonObject=new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success"))
                            {

                                Toast.makeText(getApplicationContext(),"SUCCESS"+jsonObject.getString("success"),Toast.LENGTH_LONG);

                                startActivity(new Intent(getApplicationContext(),donner_dashboard.class));


                            }
                            else
                            {
                                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                alert.setMessage(jsonObject.getString("error"));
                                alert.show();
                                Toast.makeText(getApplicationContext(),"ERROR"+jsonObject.getString("error"),Toast.LENGTH_LONG);
                            }   }

                        catch (JSONException ex)
                        {
                            ex.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (volleyError.networkResponse == null) {
                            if (volleyError.getClass().equals(TimeoutError.class)) {
                                // Show timeout error message
                                Toast.makeText(getApplicationContext(),
                                        "Oops. Timeout error!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashmap=new HashMap<String,String>();
                        hashmap.put("email",txtemail.getText().toString());
                        hashmap.put("password",txtpass.getText().toString());
                        return hashmap;
                    }
                };
                rq.add(request);

            }
        });

    }
}
