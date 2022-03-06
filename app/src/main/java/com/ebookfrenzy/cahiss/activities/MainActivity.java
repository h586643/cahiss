package com.ebookfrenzy.cahiss.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ebookfrenzy.cahiss.R;
import com.ebookfrenzy.cahiss.utils.PersonDAO;

public class MainActivity extends AppCompatActivity {

    PersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addPersonButton = findViewById(R.id.addPersonButton);
        Button startQuizButton = findViewById(R.id.startQuizButton);
        Button listOfPersonsButton = findViewById(R.id.databaseButton);

        addPersonButton.setOnClickListener(view -> startActivity(
                new Intent(MainActivity.this,
                AddPersonActivity.class)));
        startQuizButton.setOnClickListener(view -> startActivity(
                new Intent(MainActivity.this,
                QuizActivity.class)));
        listOfPersonsButton.setOnClickListener(view -> startActivity(
                new Intent(MainActivity.this,
                DatabaseActivity.class)));
    }
}