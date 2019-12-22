package com.improvement.self.awesome;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class power extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
    }

    public void cam(View view){
        Intent launch = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
        startActivity(launch);
    }

    public void insta(View view){
        Intent launch = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
        startActivity(launch);
    }

    public void what(View view) {
        Intent launch = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(launch);
    }

    public void on(View view){
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
    }

    public void off(View view){
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(false);
    }

    public void nextact(View view)
    {
        startActivity(new Intent(power.this,null));
    }
}
