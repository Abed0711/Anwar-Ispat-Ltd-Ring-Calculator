package com.example.anwarispatltdringcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    RadioButton btn8mm, btn10mm, btn12mm, btn16mm, btn20mm, btn25mm;
    String Wg;
    boolean clicked = false, clicked2 = false;

    private void click() {

        Button btn = findViewById(R.id.getBtn);
        Button btn2 = findViewById(R.id.getBtn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;

                if (clicked == true) {
                    Intent intent = new Intent(Main2Activity.this, piece.class);
                    intent.putExtra("wg", Wg);
                    startActivity(intent);

                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked2 = true;

                if (clicked2 == true) {
                    Intent intent = new Intent(Main2Activity.this, Weight.class);
                    intent.putExtra("wg", Wg);
                    startActivity(intent);


                }

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn8mm = findViewById(R.id.radioButton8);
        btn10mm = findViewById(R.id.radioButton10);
        btn12mm = findViewById(R.id.radioButton12);
        btn16mm = findViewById(R.id.radioButton16);
        btn20mm = findViewById(R.id.radioButton20);
        btn25mm = findViewById(R.id.radioButton25);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton8:
                if (checked)
                    Wg = ".12";
                click();

                break;
            case R.id.radioButton10:
                if (checked)
                    Wg = ".18";

                click();
                break;
            case R.id.radioButton12:
                if (checked)
                    Wg = ".27";
                click();
                break;
            case R.id.radioButton16:
                if (checked)
                    Wg = ".48";
                click();
                break;
            case R.id.radioButton20:
                if (checked)
                    Wg = ".75";
                click();
                break;
            case R.id.radioButton25:
                if (checked)
                    Wg = "1.17";
                click();
                break;
        }

    }
}