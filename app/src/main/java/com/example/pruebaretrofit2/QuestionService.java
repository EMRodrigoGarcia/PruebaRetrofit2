package com.example.pruebaretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {

    @GET("polls/api/question/")
    Call<List<Question>> listIncidencias();
}