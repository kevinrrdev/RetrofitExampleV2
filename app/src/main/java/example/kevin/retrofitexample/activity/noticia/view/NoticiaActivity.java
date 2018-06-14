package example.kevin.retrofitexample.activity.noticia.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.kevin.retrofitexample.R;
import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;

import example.kevin.retrofitexample.activity.noticia.presenter.NoticiaPresenter;
import example.kevin.retrofitexample.activity.noticia.presenter.Presenter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.api.request.NoticiaRequest;
import example.kevin.retrofitexample.api.response.NoticiaResponse;
import example.kevin.retrofitexample.model.NoticiasModel;
import example.kevin.retrofitexample.model.UsuarioModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NoticiaActivity extends AppCompatActivity implements example.kevin.retrofitexample.activity.noticia.view.View {
    EditText etLugar,etNoticia;
    Button btnGuardar;

    Presenter presenter;
    NoticiasModel objNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.app_noticia);
        initView();
        setUi();


    }

    void initView(){
        etLugar = findViewById(R.id.etLugar);
        etNoticia = findViewById(R.id.etNoticia);
        btnGuardar = findViewById(R.id.btnGuardar);
    }

    void setUi(){
        presenter = new NoticiaPresenter(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getData()){
                    presenter.doRegistrar(objNoticia);
                }
            }
        });
    }

    boolean getData(){
        boolean success;
        objNoticia= new NoticiasModel();
        objNoticia.setLugar(etLugar.getText().toString());
        objNoticia.setNoticia(etNoticia.getText().toString());
        UsuarioModel objUsuario = new UsuarioModel();
        objUsuario.setIdusuario(ID_USUARIO);
        objNoticia.setUsuario(objUsuario);
        success = true;

        return success;
    }




    @Override
    public void showResult(String result) {
        setResult(Activity.RESULT_OK);
        Toast.makeText(NoticiaActivity.this, result, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(NoticiaActivity.this, error, Toast.LENGTH_LONG).show();
    }
}
