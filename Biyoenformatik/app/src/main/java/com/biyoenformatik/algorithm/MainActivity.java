package com.biyoenformatik.algorithm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onJuckesActivity(View view) {
        Intent intemt=new Intent(this,JukesCantorModel.class);
        startActivity(intemt);
    }

    public void onKimunaActivity(View view) {
        Intent intemt=new Intent(this,KimuraModel.class);
        startActivity(intemt);
    }
}
