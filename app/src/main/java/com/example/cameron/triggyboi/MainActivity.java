package com.example.cameron.triggyboi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button rightButton, nonRightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rightButton = findViewById(R.id.rightButton);
        nonRightButton = findViewById(R.id.nonRightButton);

        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                changeScreen("right");
            }
        });

        nonRightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                changeScreen("non-right");
            }
        });
    }

    void changeScreen(String screen) {
        Intent intent;

        if(screen.equals("right")) {
            intent = new Intent(this, RightTriangleActivity.class);
            startActivity(intent);
            return;
        }
        else if(screen.equals("non-right")) {
            intent = new Intent(this, nonRightTriangleActivity.class);
            startActivity(intent);
            return;
        }
    }
}
