package example.kevin.retrofitexample.activity.registrar.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import example.kevin.retrofitexample.R;
import example.kevin.retrofitexample.activity.registrar.presenter.Presenter;
import example.kevin.retrofitexample.activity.registrar.presenter.RegistrarPresenter;
import example.kevin.retrofitexample.model.UsuarioModel;

public class RegistrarActivity extends AppCompatActivity implements example.kevin.retrofitexample.activity.registrar.view.View{


    private EditText etNombre,etApellido,etEdad,etUsuario,etPassword;
    private ProgressBar pbLoading;
    private Button btnRegistrar;
    private Presenter presenter;
    private UsuarioModel usuarioModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        setTitle(R.string.app_registrar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        setUi();
    }
    private void initView(){
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        pbLoading = findViewById(R.id.pbLoading);
    }

    private void setUi(){

        presenter = new RegistrarPresenter(this);

        pbLoading.setVisibility(View.GONE);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getData()){
                    presenter.doRegistrar(usuarioModel);
                }
                else
                    return;
               
            }
        });

    }
    private boolean getData(){
        boolean success;
        usuarioModel = new UsuarioModel();
        usuarioModel.setNombre(etNombre.getText().toString());
        usuarioModel.setApellido(etApellido.getText().toString());
        usuarioModel.setEdad(Integer.valueOf(etEdad.getText().toString()));
        usuarioModel.setUsuario(etUsuario.getText().toString());
        usuarioModel.setPassword(etPassword.getText().toString());
        success=true;
        return success;
    }

 
    @Override
    public void showResult(String result) {

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        this.finish();

    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


}
