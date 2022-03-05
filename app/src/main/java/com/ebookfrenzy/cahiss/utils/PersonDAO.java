package com.ebookfrenzy.cahiss.utils;

import androidx.room.*;
import java.util.List;

@Dao
public interface PersonDAO {

    @Query("SELECT * FROM persons")
    List<Person> getAllPersons();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
