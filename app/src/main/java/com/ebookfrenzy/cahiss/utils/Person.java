package com.ebookfrenzy.cahiss.utils;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "persons")
public class Person {

    // Class (database) variables
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] image;

    boolean correctPerson;


    // Getter & setter for ID
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    // Getter & setter for name
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    // Getter & setter for image
    public byte[] getImage() {

        return image;
    }

    public void setImage(byte[] image) {

        this.image = image;
    }

    // Getter & setter for correct person
    public boolean getCorrectPerson() {
        return correctPerson;
    }

    public void setCorrectPerson(Boolean correctPerson) {
        this.correctPerson = correctPerson;
    }
}
