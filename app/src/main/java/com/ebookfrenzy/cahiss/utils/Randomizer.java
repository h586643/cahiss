package com.ebookfrenzy.cahiss.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Randomizer {

    private Person previousPerson;
    private Person correctPerson;
    private List<Person> personList;

    // Constructor only needs to take list to instantiate
    public Randomizer(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> generateAnswerOptions() {

        List<Person> answerOptionsList = new ArrayList<>();
        answerOptionsList.add(this.correctPerson);

        int indexOfCorrectAnswer = personList.indexOf(this.correctPerson);
        int indexOfOption2 = 0;
        int indexOfOption3 = 0;

        if (indexOfCorrectAnswer == personList.size() - 1) {
            indexOfOption2 = indexOfCorrectAnswer - 1;
            indexOfOption3 = indexOfCorrectAnswer - 2;

        } else if (indexOfCorrectAnswer == 0) {
            indexOfOption2 = indexOfCorrectAnswer + 1;
            indexOfOption3 = indexOfCorrectAnswer + 2;

        } else {
            indexOfOption2 = indexOfCorrectAnswer + 1;
            indexOfOption3 = indexOfCorrectAnswer - 1;
        }

        Person option2 = personList.get(indexOfOption2);
        Person option3 = personList.get(indexOfOption3);
        answerOptionsList.add(option2);
        answerOptionsList.add(option3);

        Collections.shuffle(answerOptionsList);
        return answerOptionsList;
    }

    public Person generateCorrectPerson() {
        int index = generateRandomIndex();

        if (index == personList.indexOf(previousPerson)) {
            index = generateRandomIndex();
        }

        this.correctPerson = personList.get(index);
        setPreviousPerson(correctPerson);
        this.correctPerson.setCorrectPerson(true);

        return this.correctPerson;
    }

    // Private helper methods
    private int generateRandomIndex() {
        return 0 + (int)(Math.random() * (personList.size()));
    }

    private void setPreviousPerson(Person person) {
        this.previousPerson = person;
    }

    private Person getPreviousPerson() {
        return this.previousPerson;
    }
}
