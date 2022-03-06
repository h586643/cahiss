package com.ebookfrenzy.cahiss.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ebookfrenzy.cahiss.R;
import com.ebookfrenzy.cahiss.utils.Person;
import com.ebookfrenzy.cahiss.utils.PersonDAO;
import com.ebookfrenzy.cahiss.utils.PersonDatabase;
import com.ebookfrenzy.cahiss.utils.SorterHelper;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_persons);

        recyclerView = findViewById(R.id.userRecyclerView);

        personDAO = PersonDatabase.getDBInstance(this).personDAO();
        PersonRecycler personRecycler = new PersonRecycler(personDAO.getAllPersons(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personRecycler);
    }

    public void sortAlphabetically(View view){

        personDAO = PersonDatabase.getDBInstance(this).personDAO();
        List<Person> personList = personDAO.getAllPersons();

        SorterHelper sorterHelper = new SorterHelper(personList);
        sorterHelper.sortAlphabetically();
        PersonRecycler personRecycler = new PersonRecycler(sorterHelper.getSortedPersonList(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personRecycler);
    }

    public void sortAlphabeticallyReversed(View view) {
        personDAO = PersonDatabase.getDBInstance(this).personDAO();
        List<Person> personList = personDAO.getAllPersons();

        SorterHelper sorterHelper = new SorterHelper(personList);
        sorterHelper.sortAlphabeticallyReversed();
        PersonRecycler personRecycler = new PersonRecycler(sorterHelper.getSortedPersonList(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personRecycler);
    }

    public void addPerson(View v){
        startActivity(new Intent(DatabaseActivity.this, AddPersonActivity.class));
    }
}
