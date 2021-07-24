package com.example.anwarispatltdringcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Weight extends Main2Activity {

    EditText foot, inch, piece;
    public double f, i, x, m, w, l;
    Button btn;
    String ft = "0", in = "0", ps = "0";
    String s = ".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);


        foot = findViewById(R.id.p1);
        inch = findViewById(R.id.p2);
        piece = findViewById(R.id.p3);
        btn = findViewById(R.id.buttonnxt);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = foot.getText().toString();
                in = inch.getText().toString();
                ps = piece.getText().toString();

                if (ft.equals(s) || in.equals(s) || ps.equals(s)) {
                    Toast.makeText(Weight.this, "শুধুমাত্র দশমিক বসাবেন না !", Toast.LENGTH_SHORT).show();

                } else if (ft.length() != 0 && in.length() != 0 && ps.length() != 0) {

                    f = Double.parseDouble(ft);
                    i = Double.parseDouble(in);
                    x = Double.parseDouble(ps);


                    l = f + i / 12;


                    Intent intent = getIntent();
                    String str = intent.getStringExtra("wg");

                    w = Double.parseDouble(str);

                    m = (w * l * x);


                    String str2 = String.valueOf(m);
                    openDialog(str2);

//                    Intent intent2 = new Intent(Weight.this, Dialog.class);
//                   intent2.putExtra("weightans", str2);
//                    startActivity(intent2);
                } else {
                    Toast.makeText(Weight.this, "সব গুলি ঘর পূরণ করুন,কোনো মান না থাকলে ০ বসান !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void openDialog(String str2) {

        Dialog exampleDialog = new Dialog(str2);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }
}