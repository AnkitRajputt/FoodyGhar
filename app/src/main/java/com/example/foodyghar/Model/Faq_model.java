package com.example.foodyghar.Model;

public class Faq_model {

    private String questions, answers;
    private boolean expandle;


    public boolean isExpandle() {
        return expandle;
    }

    public void setExpandle(boolean expandle) {
        this.expandle = expandle;
    }

    public Faq_model(String questions, String answers) {
        this.questions = questions;
        this.answers = answers;
        this.expandle = false;

    }


    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "questions='" + questions + '\'' +
                ", answers='" + answers + '\'' +
                '}';
    }
}
