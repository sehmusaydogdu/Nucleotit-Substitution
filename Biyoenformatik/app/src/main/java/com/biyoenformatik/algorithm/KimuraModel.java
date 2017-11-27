package com.biyoenformatik.algorithm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KimuraModel extends Activity {

    EditText editTransversion,editTransition;
    TextView txtSonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kimuna_model);
        KimuraModel.this.setTitle("Kimura Model");
        editTransition=(EditText)findViewById(R.id.editTransition);
        editTransversion=(EditText)findViewById(R.id.editTransversion);
        txtSonuc=(TextView)findViewById(R.id.txtSonuc);
    }

    public void onHesapla(View view) {

        try {
           float transition=Float.parseFloat(editTransition.getText().toString());
           float transversion=Float.parseFloat(editTransversion.getText().toString());

           float uzaklik= (float) ((0.5)*Math.log(1.0/(1.0-2.0*transition-transversion))+(0.25)*Math.log(1.0/(1.0-2.0*transversion)));
           txtSonuc.setText("Sonuç  :  "+uzaklik);

        }
        catch (Exception e){
            Toast.makeText(this,"Girilen Değerleri Kontrol Ediniz.",Toast.LENGTH_SHORT).show();
        }
    }
}
