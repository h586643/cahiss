package com.ebookfrenzy.cahiss.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ebookfrenzy.cahiss.R;
import com.ebookfrenzy.cahiss.utils.ImageConverter;
import com.ebookfrenzy.cahiss.utils.Person;
import com.ebookfrenzy.cahiss.utils.PersonDAO;
import com.ebookfrenzy.cahiss.utils.PersonDatabase;
import com.ebookfrenzy.cahiss.utils.Randomizer;
import com.ebookfrenzy.cahiss.utils.Score;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Person correctPerson;
    private QuizViewModel model;
    PersonDAO personDAO;
    Score score;
    TextView resultView;
    Button onNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);
        onNext = findViewById(R.id.nextQuestionButton);
        resultView = findViewById(R.id.result);
        score = new Score();

        model = new ViewModelProvider(this).get(QuizViewModel.class);

        final Observer<String> scoreObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String score) {
                resultView.setText(score);
            }
        };

        model.getScore().observe(this, scoreObserver);
        personDAO = PersonDatabase.getDBInstance(this).personDAO();
    }

    public void onNextQuestion(View view) {
        List<Person> personList = personDAO.getAllPersons();

        Randomizer randomizer = new Randomizer(personList);

        ImageView imageView = findViewById(R.id.personPicture);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        answer1.setBackgroundColor(getResources().getColor(R.color.white));
        answer2.setBackgroundColor(getResources().getColor(R.color.white));
        answer3.setBackgroundColor(getResources().getColor(R.color.white));

        correctPerson = randomizer.generateCorrectPerson();
        List<Person> answerOptionsList = randomizer.generateAnswerOptions();
        imageView.setImageBitmap(ImageConverter.convertByteArrayToImage(correctPerson.getImage()));

        answer1.setText(personList.get(0).getName());
        answer2.setText(personList.get(1).getName());
        answer3.setText(personList.get(2).getName());

        onClickAnswer(view, answer1, answer2, answer3, correctPerson, score, model);
    }

    public void onClickAnswer(View v, Button answer1, Button answer2, Button answer3, Person p, Score score, QuizViewModel model) {

        answer1.setOnClickListener(view -> {
            if (updateScore(p, answer1, score, model)) {
                answer1.setBackgroundColor(getResources().getColor(R.color.green));
                resultView.setText("Riktig svar!");
            } else {
                answer1.setBackgroundColor(getResources().getColor(R.color.red));
                resultView.setText("Feil svar.");
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (updateScore(p, answer1, score, model)) {
                    answer2.setBackgroundColor(getResources().getColor(R.color.green));
                    resultView.setText("Riktig svar!");
                } else {
                    answer2.setBackgroundColor(getResources().getColor(R.color.red));
                    resultView.setText("Feil svar.");
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (updateScore(p, answer1, score, model)) {
                    answer3.setBackgroundColor(getResources().getColor(R.color.green));
                    resultView.setText("Riktig svar!");
                } else {
                    answer3.setBackgroundColor(getResources().getColor(R.color.red));
                    resultView.setText("Feil svar.");
                }
            }
        });
    }

    private boolean updateScore(Person p, TextView answer, Score score, QuizViewModel model) {

        boolean correct = false;

        if (p.getName().toLowerCase().equals(answer.getText().toString().toLowerCase())) {
            correct = true;
            score.setScore();
        }

        score.setAttempts();
        model.getScore().setValue(score.toString());
        return correct;
    }
}
