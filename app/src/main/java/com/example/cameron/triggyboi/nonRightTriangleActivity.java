package com.example.cameron.triggyboi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class nonRightTriangleActivity extends AppCompatActivity {

    EditText sideAText, angleAText, sideBText, angleBText, sideCText, angleCText;
    Button solveButton, resetButton;
    NonRightTrigEqs tigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_right_triangle);

        tigger = new NonRightTrigEqs();
        sideAText = findViewById(R.id.sideAText);
        angleAText = findViewById(R.id.angleAText);
        sideBText = findViewById(R.id.sideBText);
        angleBText = findViewById(R.id.angleBText);
        sideCText = findViewById(R.id.sideCText);
        angleCText = findViewById(R.id.angleCText);
        solveButton = findViewById(R.id.solveButton);
        resetButton = findViewById(R.id.resetButton);

        solveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double sA, aA, sB, aB, sC, aC;

                try {
                    sA = Double.parseDouble(sideAText.getText().toString());
                }
                catch(NumberFormatException e) {
                    sA = 0;
                }

                try {
                    aA = Double.parseDouble(angleAText.getText().toString());
                }
                catch(NumberFormatException e) {
                    aA = 0;
                }

                try {
                    sB = Double.parseDouble(sideBText.getText().toString());
                }
                catch(NumberFormatException e) {
                    sB = 0;
                }

                try {
                    aB = Double.parseDouble(angleBText.getText().toString());
                }
                catch(NumberFormatException e) {
                    aB = 0;
                }

                try {
                    sC = Double.parseDouble(sideCText.getText().toString());
                }
                catch(NumberFormatException e) {
                    sC = 0;
                }

                try {
                    aC = Double.parseDouble(angleCText.getText().toString()); }
                catch(NumberFormatException e) {
                    aC = 0;
                }

                tigger.setVars(sA, aA, sB, aB, sC, aC);
                tigger.solveTriangle();
                setTextValues();

            }


        });

        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tigger.setVars(0, 0, 0, 0, 0, 0);
                setTextValues();
            }
        });
    }

    void setTextValues() {
        sideAText.setText(Double.toString(tigger.getSideA()));
        angleAText.setText(Double.toString(tigger.getAngleA()));
        sideBText.setText(Double.toString(tigger.getSideB()));
        angleBText.setText(Double.toString(tigger.getAngleB()));
        sideCText.setText(Double.toString(tigger.getSideC()));
        angleCText.setText(Double.toString(tigger.getAngleC()));
    }
}
