package example.kevin.retrofitexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.kevin.retrofitexample.R;
import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.api.request.NoticiaRequest;
import example.kevin.retrofitexample.api.response.NoticiaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NoticiaActivity extends AppCompatActivity {
    EditText etLugar,etNoticia;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.app_noticia);
        setUi();


    }

    void setUi(){
        etLugar = findViewById(R.id.etLugar);
        etNoticia = findViewById(R.id.etNoticia);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNoticia();
            }
        });
    }


    void guardarNoticia(){

        NoticiaRequest request= new NoticiaRequest();
        request.setIdusuario(ID_USUARIO);
        request.setLugar(etLugar.getText().toString());
        request.setNoticia(etNoticia.getText().toString());

        Call<NoticiaResponse> responseCall= ApiClient.getApiClient().registerNoticia(request);

        responseCall.enqueue(new Callback<NoticiaResponse>() {
            @Override
            public void onResponse(Call<NoticiaResponse> call, Response<NoticiaResponse> response) {
                if (response.isSuccessful()) {
                    NoticiaResponse dataResponse = response.body();
                    if (dataResponse.isSuccess()) {
                        setResult(Activity.RESULT_OK);
                        finish();

                        Toast.makeText(NoticiaActivity.this, "Mensaje del servidor: " + dataResponse.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<NoticiaResponse> call, Throwable t) {

            }
        });
    }
}
