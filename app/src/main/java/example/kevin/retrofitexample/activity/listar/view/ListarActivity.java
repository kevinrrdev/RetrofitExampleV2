package example.kevin.retrofitexample.activity.listar.view;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import example.kevin.retrofitexample.R;
import example.kevin.retrofitexample.activity.listar.presenter.ListarPresenter;
import example.kevin.retrofitexample.activity.listar.presenter.Presenter;
import example.kevin.retrofitexample.activity.noticia.view.NoticiaActivity;
import example.kevin.retrofitexample.adapter.RecyclerViewAdapter;
import example.kevin.retrofitexample.model.NoticiasModel;
import example.kevin.retrofitexample.utils.Constantes;

import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;
import static example.kevin.retrofitexample.utils.Constantes.RQ_AGREGAR;

public class ListarActivity extends AppCompatActivity implements example.kevin.retrofitexample.activity.listar.view.View {

    FloatingActionButton fabAgregar;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView mRecyclerView;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle(R.string.app_listar);

        initView();
        setUi();
        cagarNoticias();

    }

    void initView(){
        mRecyclerView = findViewById(R.id.rvNoticias);
        fabAgregar= findViewById(R.id.fabAdd);
    }
    void setUi(){
        presenter = new ListarPresenter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAgregar = new Intent(ListarActivity.this,NoticiaActivity.class);
                startActivityForResult(iAgregar, RQ_AGREGAR);
            }
        });
    }


    void cagarNoticias(){
        presenter.getData(ID_USUARIO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == Constantes.RQ_AGREGAR){
            if (resultCode == Activity.RESULT_OK){ cagarNoticias(); }
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<NoticiasModel> list) {
        recyclerViewAdapter = new RecyclerViewAdapter(list);

        mRecyclerView.setAdapter(recyclerViewAdapter);

    }
}
