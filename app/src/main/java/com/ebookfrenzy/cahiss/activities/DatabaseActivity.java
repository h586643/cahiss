package com.ebookfrenzy.cahiss.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ebookfrenzy.cahiss.R;
import com.ebookfrenzy.cahiss.utils.PersonDAO;

public class DatabaseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
    }
}
