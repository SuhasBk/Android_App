package com.improvement.self.awesome;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class FlaskRestDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flask_rest_demo);
    }

    public void FindMeaning(View view)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://masterbyte.herokuapp.com/dictionary";
        TextInputEditText input = (TextInputEditText) findViewById(R.id.word);
        String word = input.getText().toString();
        final TextView tv = (TextView) findViewById(R.id.meaning);
        tv.setMovementMethod(new ScrollingMovementMethod());

        JSONObject data = new JSONObject();
        try{
            data.put("word", word);
        }
        catch(Exception e){}

        JsonObjectRequest object = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tv.setVisibility(View.VISIBLE);
                try {
                    tv.setText(response.get("response").toString());
                } catch (Exception e) {
                    tv.setText(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("Check your internet connection and try again...");
            }
        });
        queue.add(object);
    }
}
