package example.kevin.retrofitexample.activity.listar.model;

import java.util.List;

import example.kevin.retrofitexample.activity.listar.presenter.Presenter;
import example.kevin.retrofitexample.api.ApiClient;
import example.kevin.retrofitexample.model.NoticiasModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class ListarModel implements Model {

    Presenter presenter;
    List<NoticiasModel> mListNoticias;
    int id;

    public ListarModel(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void getData(int idUsuario) {
        id=idUsuario;
        llenarLista();
    }

    void llenarLista(){
        Call<List<NoticiasModel>> responseCall= ApiClient.getApiClient().getNoticias(id);
        responseCall.enqueue(new Callback<List<NoticiasModel>>() {
            @Override
            public void onResponse(Call<List<NoticiasModel>> call, Response<List<NoticiasModel>> response) {
                if (response.isSuccessful()){
                    List<NoticiasModel> lista = response.body();
                    if (lista!=null){
                        mListNoticias=lista;
                        presenter.setData(mListNoticias);
                    }else
                    {
                        String msgError;
                        msgError = "Lista vacía.";

                        presenter.showError(msgError);
                    }
                }else {
                    String msgError;
                    msgError = "Error en Model onResponse ";

                    presenter.showError(msgError);
                }
            }

            @Override
            public void onFailure(Call<List<NoticiasModel>> call, Throwable t) {
                String msgError;
                msgError = "Error en Model onFailure";

                presenter.showError(msgError);

            }
        });
    }
}
