package example.kevin.retrofitexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import example.kevin.retrofitexample.R;
import example.kevin.retrofitexample.adapter.RecyclerViewAdapter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.model.NoticiasModel;
import example.kevin.retrofitexample.utils.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;
import static example.kevin.retrofitexample.utils.Constantes.RQ_AGREGAR;

public class ListActivity extends AppCompatActivity {

    FloatingActionButton fabAgregar;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView mRecyclerView;
    List<NoticiasModel> mListNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle(R.string.app_listar);
        mRecyclerView = findViewById(R.id.rvNoticias);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabAgregar= findViewById(R.id.fabAdd);
        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAgregar = new Intent(ListActivity.this,NoticiaActivity.class);
                startActivityForResult(iAgregar, RQ_AGREGAR);
            }
        });

        cagarNoticias();

    }


    void cagarNoticias(){

        int idusuario= ID_USUARIO;

        Call<List<NoticiasModel>> responseCall= ApiClient.getApiClient().getNoticias(idusuario);
        responseCall.enqueue(new Callback<List<NoticiasModel>>() {
            @Override
            public void onResponse(Call<List<NoticiasModel>> call, Response<List<NoticiasModel>> response) {
                if (response.isSuccessful()){
                    List<NoticiasModel> lista = response.body();
                    if (lista!=null){

                        mListNoticias=lista;


                        recyclerViewAdapter = new RecyclerViewAdapter(mListNoticias);

                        mRecyclerView.setAdapter(recyclerViewAdapter);


                    }
                }
            }

            @Override
            public void onFailure(Call<List<NoticiasModel>> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == Constantes.RQ_AGREGAR){
            if (resultCode == Activity.RESULT_OK){
                cagarNoticias();
            }

        }
    }
}
