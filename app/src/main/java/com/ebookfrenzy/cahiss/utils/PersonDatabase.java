package com.ebookfrenzy.cahiss.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ebookfrenzy.cahiss.R;

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

            // Adding Iselin to database
            Person iselin = new Person();

            iselin.setName("Iselin");
            Bitmap ise = BitmapFactory.decodeResource(context.getResources(), R.drawable.iselin);
            if(ise != null) {
                iselin.setImage(ImageConverter.convertImageToByte(ise));
            }


            personDB.personDAO().insertPerson(iselin);

            // Adding Isabella to database
            Person isabella = new Person();

            isabella.setName("Isabella");
            Bitmap isa = BitmapFactory.decodeResource(context.getResources(), R.drawable.isabella);
            if(isa != null) {
                isabella.setImage(ImageConverter.convertImageToByte(isa));
            }
            personDB.personDAO().insertPerson(isabella);

            // Adding Cathrine to database hiho
            Person cathrine = new Person();

            cathrine.setName("Cathrine");
            Bitmap cat = BitmapFactory.decodeResource(context.getResources(), R.drawable.cathrine);
            if(cat != null) {
                cathrine.setImage(ImageConverter.convertImageToByte(cat));
            }
            personDB.personDAO().insertPerson(cathrine);

        }
        return personDB;
    }
}
