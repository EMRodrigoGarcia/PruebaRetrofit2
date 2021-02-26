package com.example.pruebaretrofit2;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoQuestionsViewModel extends ViewModel {
    private MutableLiveData<List<Question>> datos;


    public LiveData<List<Question>> getDatos() {
        if (datos == null) {
            datos = new MutableLiveData<>();
            datos.setValue(new ArrayList<Question>());
            cargarDatos();
        }

        return datos;
    }

    private void cargarDatos() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.44:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            QuestionService service = retrofit.create(QuestionService.class);
            Call<List<Question>> peticion = service.listIncidencias();

            peticion.enqueue(new Callback<List<Question>>() {
                @Override
                public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                    if (response.isSuccessful()) {
                        datos.postValue(response.body());
                    }else {
                        Log.i("viewmodel", "onResponse: " + "error de api");
                    }


                }

                @Override
                public void onFailure(Call<List<Question>> call, Throwable t) {
                    //Toast.makeText(getApplication(), "Error de api", Toast.LENGTH_LONG).show();
                    Log.i("viewmodel", "onFailure: error catastrofico");
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
