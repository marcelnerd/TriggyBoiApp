package com.example.cameron.triggyboi;
// test comment   gg
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RightTriangleActivity extends AppCompatActivity {

    Button solveButton, resetButton;
    EditText hypotText, aText, bText, thetaText, detaText;
    TrigEqs trigy = new TrigEqs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_triangle);
        hypotText = findViewById(R.id.hypotView);
        aText = findViewById(R.id.aView);
        bText = findViewById(R.id.bView);
        thetaText = findViewById(R.id.thetaView);
        detaText = findViewById(R.id.detaView);
        solveButton = findViewById(R.id.solveButton);
        resetButton = findViewById(R.id.resetButton);

        solveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Double.parseDouble(hypotText.getText().toString()))
                double setT, setD, setB, setA, setH;

                try {
                    setT = Double.parseDouble(thetaText.getText().toString());
                }
                catch(NumberFormatException e) {
                    setT = 0;
                }

                try {
                    setD = Double.parseDouble(detaText.getText().toString());
                }
                catch(NumberFormatException e) {
                    setD = 0;
                }

                try {
                    setA = Double.parseDouble(aText.getText().toString());
                }
                catch(NumberFormatException e) {
                    setA = 0;
                }

                try {
                    setB = Double.parseDouble(bText.getText().toString());
                }
                catch(NumberFormatException e) {
                    setB = 0;
                }

                try {
                    setH = Double.parseDouble(hypotText.getText().toString());
                }
                catch(NumberFormatException e) {
                    setH = 0;
                }
                trigy.setVars(setT, setD, setA, setB, setH);
                trigy.solveTriangle();
                setTextValues();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trigy.setVars(0, 0, 0, 0, 0);
                setTextValues();
            }
        });
    }



    public void setTextValues() {
        hypotText.setText(Double.toString(trigy.getHypot()));
        aText.setText(Double.toString(trigy.getLegA()));
        bText.setText(Double.toString(trigy.getLegB()));
        thetaText.setText(Double.toString(trigy.getTheta()));
        detaText.setText(Double.toString(trigy.getDeta()));

    }
}
