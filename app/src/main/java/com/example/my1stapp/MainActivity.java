package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my1stapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

//        setContentView(R.layout.activity_main); //R is a class in android.
        setContentView(view);

        //
        //Change the Welcome Message
        //

        //Change the Welcome Message
//        TextView textWelcome = findViewById(R.id.textWelcome);
        TextView textWelcome = binding.textWelcome;

        Log.i("TESTING","The Value of TextMessage " + textWelcome.getText().toString());

        String welcomeMessage = "Welcome to Android - Java";
        String welcomeMessage2 = getResources().getString(R.string.welcome_message);
        textWelcome.setText(welcomeMessage);

        //
        // ADD Views Dynamically
        //

        for(int i = 0; i < 5; i++) {
            TextView textView = new TextView(this);
            String textViewText = "Text View " + String.valueOf(i);
            textView.setText(textViewText);
            textView.setTextColor(ColorStateList.valueOf(Color.WHITE));

            LinearLayout linearLayout  = findViewById(R.id.linearLayout);
            binding.linearLayout.addView(textView);
        }

        //
        //Handle Button Click
        //


        Button buttonSubmit = binding.buttonSubmit;

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = binding.editTextName.getText().toString(); //same thing as below
                String message = "Submit button Clicked! Hello " + binding.editTextName.getText().toString();
                Log.i("TESTING","Submit Button Clicked! Hello " + binding.editTextName.getText().toString());

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}