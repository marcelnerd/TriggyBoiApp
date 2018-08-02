/*
Author and Creator: Damien Q
This app is a trigonometry helper. Given parts of a triangle (right or non-right), it can solve for all the other parts possible


 */

package com.example.cameron.triggyboi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button rightButton, nonRightButton; // The opening screen simply allows the user to choose between solving a right or non-right triange.

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
