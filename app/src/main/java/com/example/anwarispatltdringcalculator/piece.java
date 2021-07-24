package com.example.anwarispatltdringcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class piece extends Main2Activity {

    EditText foot, inch, m;
    public double f, i, x = 0, mas, w, l;
    Button btn;
    String ft = "0", in = "0", ms = "0", s = ".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piece);


        foot = findViewById(R.id.p1);
        inch = findViewById(R.id.p2);
        m = findViewById(R.id.p3);
        btn = findViewById(R.id.buttonnxt);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ft = foot.getText().toString();
                in = inch.getText().toString();
                ms = m.getText().toString();


                if (ft.equals(s) || in.equals(s) || ms.equals(s)) {
                    Toast.makeText(piece.this, "শুধুমাত্র দশমিক বসাবেন না !", Toast.LENGTH_SHORT).show();

                } else if (ft.length() != 0 && in.length() != 0 && ms.length() != 0) {

                    f = Double.parseDouble(ft);
                    i = Double.parseDouble(in);
                    mas = Double.parseDouble(ms);

                    l = f * 12 + i;


                    Intent intent = getIntent();
                    String str = intent.getStringExtra("wg");

                    w = Double.parseDouble(str);

                    x = ((mas * (12 / l)) / w);


                    String str2 = String.valueOf(x);
                    openDialog(str2);


                } else {
                    Toast.makeText(piece.this, "সব গুলি ঘর পূরণ করুন, কোনো মান না থাকলে ০ বসান !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void openDialog(String str2) {

        Dialog1 exampleDialog = new Dialog1(str2);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }
}