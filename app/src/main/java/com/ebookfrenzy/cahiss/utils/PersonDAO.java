package com.ebookfrenzy.cahiss.utils;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDAO {

    @Query("SELECT * FROM Persons")
    List<Person> getAllPersons();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
