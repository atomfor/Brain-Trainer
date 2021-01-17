package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewResult;
    private TextView textViewNameResult;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        textViewResult = findViewById(R.id.textViewResult);
        textViewNameResult = findViewById(R.id.textViewNameResult);
        Intent intent = getIntent();

        if (intent != null &&  intent.hasExtra("result") && intent.hasExtra("name")) {
        name = intent.getStringExtra("name");
        int result = intent.getIntExtra("result", 0);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = preferences.getInt("max", 0);
        textViewNameResult.setText(name);
        String score = String.format("Ваш результат: %s\nМаксимальный результат: %s", result, max);
        textViewResult.setText(score);
        }
    }

    public void onClickStartNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}