package example.kevin.retrofitexample.activity.login.model;


import android.os.AsyncTask;

import example.kevin.retrofitexample.activity.login.presenter.Presenter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.api.request.LoginRequest;
import example.kevin.retrofitexample.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static example.kevin.retrofitexample.utils.Constantes.APELLIDO_USUARIO;
import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;
import static example.kevin.retrofitexample.utils.Constantes.NOMBRE_USUARIO;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class LoginModel implements Model {

    private Presenter presenter;
    private String usuario,password;

    public LoginModel(Presenter presenter){

        this.presenter = presenter;

    }

    @Override
    public void doLogin(String usuario, String password) {

        this.usuario = usuario;
        this.password= password;
        new SignIn().execute();
        String msgLogin;
        msgLogin = "Error Model onFailure";

    }

    void login(){

        LoginRequest DataRequest = new LoginRequest();
        DataRequest.setUsuario(usuario);
        DataRequest.setPassword(password);

        Call<LoginResponse> responseCall = ApiClient.getApiClient().doLogin(DataRequest);

        responseCall.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    LoginResponse dataResponse = response.body();
                    if (dataResponse.isSuccess()) {
                        ID_USUARIO = dataResponse.getUsuario().getIdusuario();
                        NOMBRE_USUARIO = dataResponse.getUsuario().getNombre();
                        APELLIDO_USUARIO = dataResponse.getUsuario().getApellido();
                        String msgLogin;
                        msgLogin = "Bienvenido "+ NOMBRE_USUARIO + " "+APELLIDO_USUARIO;
                        presenter.showResultLogin(msgLogin);
                    }else
                    {
                        presenter.showErrorLogin(dataResponse.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String msgLogin;
                msgLogin = "Error Model onFailure";
                presenter.showErrorLogin(msgLogin);
                //Log.i("LOGIN", "onFailure");
            }
        });

       if (responseCall ==null){
           presenter.showErrorLogin("Error en la conexión");
       }

    }



    public class SignIn extends AsyncTask<Void,Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {

            login();
            return true;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            //pbLoading.setVisibility(View.GONE);

        }
    }

}
