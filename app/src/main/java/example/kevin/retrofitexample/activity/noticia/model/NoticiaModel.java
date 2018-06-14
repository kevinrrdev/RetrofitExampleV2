package example.kevin.retrofitexample.activity.noticia.model;

import example.kevin.retrofitexample.activity.noticia.presenter.Presenter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.api.request.NoticiaRequest;
import example.kevin.retrofitexample.api.response.NoticiaResponse;
import example.kevin.retrofitexample.model.NoticiasModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static example.kevin.retrofitexample.utils.Constantes.ID_USUARIO;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class NoticiaModel implements Model {

    Presenter presenter;
    private NoticiasModel noticiasModel;

    public NoticiaModel(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void doRegistrar(NoticiasModel noticiasModel) {
        this.noticiasModel = noticiasModel;

        if (noticiasModel!=null){

            guardarNoticia();
        }

    }
    void guardarNoticia(){

        NoticiaRequest request= new NoticiaRequest();
        request.setIdusuario(noticiasModel.getUsuario().getIdusuario());
        request.setLugar(noticiasModel.getLugar());
        request.setNoticia(noticiasModel.getNoticia());

        Call<NoticiaResponse> responseCall= ApiClient.getApiClient().registerNoticia(request);

        responseCall.enqueue(new Callback<NoticiaResponse>() {
            @Override
            public void onResponse(Call<NoticiaResponse> call, Response<NoticiaResponse> response) {
                if (response.isSuccessful()) {
                    NoticiaResponse dataResponse = response.body();
                    if (dataResponse.isSuccess()) {

                        presenter.showResult(dataResponse.getMessage());

                    }else
                    { presenter.showError(dataResponse.getMessage());}
                }
                else {
                    presenter.showError("Error.");
                }
            }

            @Override
            public void onFailure(Call<NoticiaResponse> call, Throwable t) {
                presenter.showError("Error onFailure.");
            }
        });
    }



}
