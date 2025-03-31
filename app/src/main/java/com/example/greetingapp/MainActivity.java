package com.example.greetingapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button greetButton;
    private TextView greetingTextView;
    private androidx.constraintlayout.widget.ConstraintLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        greetButton = findViewById(R.id.greetButton);
        greetingTextView = findViewById(R.id.greetingTextView);


        mainLayout = findViewById(R.id.main);

        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String greeting;
                if (name.trim().isEmpty()){
                    greeting = "Please enter your name";
                } else {
                    greeting = "Hello, " + name + "!";
                }

                greetingTextView.setText(greeting);

                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                int colorButton = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                int colorText = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                int colorGreetingText = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                mainLayout.setBackgroundColor(color);
                greetButton.setBackgroundColor(colorButton);
                greetButton.setTextColor(colorText);
                greetingTextView.setTextColor(colorGreetingText);

            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}