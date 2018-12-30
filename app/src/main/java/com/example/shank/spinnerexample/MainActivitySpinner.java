package com.example.shank.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivitySpinner extends AppCompatActivity {

    Spinner spinner;
    RadioGroup radioGroup;
    //RadioButton r1,r2;
    RadioButton radioButton;
    String gn = "";
    String [] iteams = {"Shankar","Srsithi","Dishani","Dipayan","Saif"};
    ArrayAdapter<String> arrayAdapter;       //strongly type data mechanism

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);
        spinner = findViewById(R.id.SpinnerOp);
        radioGroup = findViewById(R.id.radioId);
        //r1 = findViewById(R.id.male);
        //r2 = findViewById(R.id.female);

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,iteams);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int ind =  parent.getSelectedItemPosition();
                String a = iteams[ind];
                Toast.makeText(MainActivitySpinner.this,"You Select "+                                                                                                                                           a, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                /*if(r1.isChecked()){
                    gn = "Male";
                }
                else if (r2.isChecked()){
                    gn = "Female";
                }*/
                radioButton = findViewById(checkedId);
                gn = radioButton.getText().toString();
                Toast.makeText(MainActivitySpinner.this, gn, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
