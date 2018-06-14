package example.kevin.retrofitexample.activity.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import example.kevin.retrofitexample.R;
import example.kevin.retrofitexample.activity.listar.view.ListarActivity;
import example.kevin.retrofitexample.activity.login.presenter.LoginPresenter;
import example.kevin.retrofitexample.activity.login.presenter.Presenter;
import example.kevin.retrofitexample.activity.registrar.view.RegistrarActivity;

public class LoginActivity extends AppCompatActivity implements example.kevin.retrofitexample.activity.login.view.View {

    private EditText etLoginID;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvSignup;
    public ProgressBar pbLoading;
    private String user,password;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.app_login);
        initView();
        setUi();
    }

    private void initView(){
        presenter = new LoginPresenter(this);

        etLoginID = findViewById(R.id.etLoginID);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup =  findViewById(R.id.tvSignup);
        pbLoading = findViewById(R.id.pbLoading);

    }

    private void setUi(){
        pbLoading.setVisibility(View.GONE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getData()){
                    pbLoading.setVisibility(View.VISIBLE);
                    presenter.doLogin(user,password);
                }else
                    return;
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iRegistrar= new Intent(LoginActivity.this,RegistrarActivity.class);
                startActivity(iRegistrar);

            }
        });
    }

    private boolean getData(){
        boolean success;
        user= etLoginID.getText().toString();
        password= etPassword.getText().toString();
        success=true;
        return success;
    }

    @Override
    public void showResultLogin(String result) {

        pbLoading.setVisibility(View.GONE);
        Intent iLista = new Intent(LoginActivity.this, ListarActivity.class);
        startActivity(iLista);
        LoginActivity.this.finish();

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrorLogin(String error) {
        pbLoading.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

}
