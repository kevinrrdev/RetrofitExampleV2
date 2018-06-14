package example.kevin.retrofitexample.activity.noticia.presenter;

import example.kevin.retrofitexample.model.NoticiasModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public interface Presenter {



    void doRegistrar(NoticiasModel noticiasModel);

    void showResult(String result);

    void showError(String error);
}
