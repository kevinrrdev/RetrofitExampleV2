package example.kevin.retrofitexample.activity.registrar.model;

import android.os.AsyncTask;
import android.view.View;

import example.kevin.retrofitexample.activity.registrar.presenter.Presenter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.api.request.UsuarioRequest;
import example.kevin.retrofitexample.api.response.UsuarioResponse;
import example.kevin.retrofitexample.model.UsuarioModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class RegistrarModel implements Model {

    Presenter presenter;
    private UsuarioModel usuarioModel;
    public RegistrarModel(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void doRegistrar(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
        new SignUp().execute();
    }

    void registar(){
        UsuarioRequest DataRequest = new UsuarioRequest();
        DataRequest.setNombre(usuarioModel.getNombre());
        DataRequest.setApellido(usuarioModel.getApellido());
        DataRequest.setEdad(usuarioModel.getEdad());
        DataRequest.setUsuario(usuarioModel.getUsuario());
        DataRequest.setPassword(usuarioModel.getPassword());

        Call<UsuarioResponse> responseCall = ApiClient.getApiClient().doRegister(DataRequest);

        responseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                if (response.isSuccessful()) {
                    UsuarioResponse dataResponse = response.body();
                    if (dataResponse.isSuccess()) {

                        //Intent iLogin = new Intent(RegistrarActivity.this, LoginActivity.class);
                        //startActivity(iLogin);
                        //Toast.makeText(RegistrarActivity.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                        //finish();
                        presenter.showResult(dataResponse.getMessage());
                    }
                    else {
                        presenter.showError(dataResponse.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }

    public class SignUp extends AsyncTask<Void,Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {

            registar();
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
