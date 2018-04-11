package com.example.android.dynamicquiz;

/**
 * Created by ngupta on 4/11/2018.
 */


import java.util.ArrayList;


/* ** Created by ngupta on 4/9/2018.*/


public class Question {
    private String qQuestion;
    private ArrayList<String> qAnswers = new ArrayList<>();
    private String qCorrectAnswer;
    private String qQuestionType;

    public Question(String question, String answers, String correctAnswer, String questionType){
        qQuestion = question;

        String[] ansList = answers.split(",");
        for (int i=0; i< ansList.length; i++) {
            qAnswers.add(ansList[i]);
        }

        qCorrectAnswer = correctAnswer;
        qQuestionType = questionType;
    }
    public String getQuestion() {
        return qQuestion;
    }

    public ArrayList<String> getAnswers() {
        return qAnswers;
    }

    public String getCorrectAnswer() {
        return qCorrectAnswer;
    }

    public String getQuestionType() {
        return qQuestionType;
    }

}

