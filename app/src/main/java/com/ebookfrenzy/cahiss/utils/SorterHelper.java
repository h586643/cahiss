package com.ebookfrenzy.cahiss.utils;

import androidx.annotation.RequiresApi;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SorterHelper {

    private List<Person> personList;

    public SorterHelper(List<Person> personList) {
        this.personList = personList;
    }

    public void sortAlphabetically() {
        Collections.sort(this.personList, new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    public void sortAlphabeticallyReversed() {
        this.personList.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
    }

    public List<Person> getSortedPersonList() {
        return this.personList;
    }
}
