package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.braintrainer.R.string.text_tost_main;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextNumberPassword);

    }

    public void onClickStart(View view) {
        String name = editTextName.getText().toString().trim();
        if (!name.isEmpty()) {
            Intent intent = new Intent(this, StartActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        } else {
            Toast.makeText(this, text_tost_main, Toast.LENGTH_SHORT).show();
        }
    }
}