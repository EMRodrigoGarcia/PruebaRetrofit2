package com.example.pruebaretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    QuestionAdapter adapter;
    ListadoQuestionsViewModel datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = findViewById(R.id.lista_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuestionAdapter(this);
        view.setAdapter(adapter);

        datos = new ViewModelProvider(this).get(ListadoQuestionsViewModel.class);

        datos.getDatos().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                ArrayList<Question> questionsArray = new ArrayList<>(questions);
                Log.i("main", "onChanged: " + questionsArray);
                adapter.addData(questionsArray);
            }
        });

    }
}