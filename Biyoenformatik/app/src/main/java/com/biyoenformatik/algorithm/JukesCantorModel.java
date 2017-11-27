package com.biyoenformatik.algorithm;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class JukesCantorModel extends Activity {

    EditText editID,editTime;
    TextView txtSonuc;
    CheckBox rdrCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukes_cantor_model);
        init();
    }

    private void init(){
        JukesCantorModel.this.setTitle("Jukes - Cantor Model");
        editID=(EditText)findViewById(R.id.editID);
        txtSonuc=(TextView)findViewById(R.id.txtSonuc);
        editTime=(EditText)findViewById(R.id.editTime);
        rdrCheck=(CheckBox)findViewById(R.id.rdrCheck);
        editTime.setEnabled(false);
        editTime.setHintTextColor(Color.GRAY);
    }
    public void onHesapla(View view) {

        try {

            float deger=Float.parseFloat(editID.getText().toString());

            if (deger>=0 && deger<=0.75){

                if (editTime.isEnabled()){
                    float alpha=Float.parseFloat(editTime.getText().toString());
                    float unchanged= (float) (0.25+(0.75)* pow(1-(4.0/3.0)*deger,alpha));
                    float changed=1-unchanged;
                    txtSonuc.setText("Değişmeden Kalma  :  "+unchanged+"\n"+
                                     "Değişme Olasılığı :  "+changed);

                }
                else {
                        float uzaklik= (float) ((-1.0)*(3.0/4.0)*Math.log(1.0-(4.0/3.0)*deger));
                        txtSonuc.setText("\n"+"Sonuç  "+"\n"+uzaklik);
                    }

            }
            else
                Toast.makeText(this,"0 ile 0.75 Aralığında Değer Giriniz.",Toast.LENGTH_SHORT).show();



        }
        catch (Exception e){
            Toast.makeText(this,"Girilen Değeri Kontrol Ediniz.",Toast.LENGTH_SHORT).show();
        }


    }

    public void onRdrClick(View view) {

        if (rdrCheck.isChecked()){
            editTime.setEnabled(true);
            editTime.setHintTextColor(Color.RED);
        }
        else{
            editTime.setEnabled(false);
            editTime.setHintTextColor(Color.GRAY);
        }

    }
}
