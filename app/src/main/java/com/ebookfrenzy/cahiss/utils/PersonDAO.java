package com.ebookfrenzy.cahiss.utils;

import androidx.room.*;
import java.util.List;

@Dao
public interface PersonDAO {

    @Query("Select * from persons")
    List<Person> getAllPersons();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
