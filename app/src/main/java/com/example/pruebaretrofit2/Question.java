package com.example.pruebaretrofit2;

import java.time.LocalDate;
import java.util.List;

public class Question {
    private String question_text;
    private String pub_date;

    public String getPub_date() {
        return pub_date;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_text='" + question_text + '\'' +
                ", pub_date=" + pub_date +
                '}';
    }
}
