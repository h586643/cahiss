package com.ebookfrenzy.cahiss.activities;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    private MutableLiveData<String> score;

    public MutableLiveData<String> getScore() {
        if (score == null) {
            score = new MutableLiveData<String>();
        }
        return score;
    }
}
