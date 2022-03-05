package com.ebookfrenzy.cahiss.utils;

import android.app.Person;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Instantiate database
@Database(
        entities = Person.class,
        version = 1,
        exportSchema = false
)

public abstract class PersonDatabase extends RoomDatabase {

    private static PersonDatabase personDB = null;
    public abstract PersonDAO personDAO();

    public static synchronized PersonDatabase getDBInstance(Context context) {
        if (personDB == null) {
            personDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PersonDatabase.class,
                    "cahiss"
            ).allowMainThreadQueries().build();
        }
        return personDB;
    }
}
