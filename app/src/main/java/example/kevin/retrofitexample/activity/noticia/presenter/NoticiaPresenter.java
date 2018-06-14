package example.kevin.retrofitexample.activity.noticia.presenter;

import example.kevin.retrofitexample.activity.noticia.model.Model;
import example.kevin.retrofitexample.activity.noticia.view.View;
import example.kevin.retrofitexample.model.NoticiasModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class NoticiaPresenter implements Presenter {

    View view;
    Model model;

    public NoticiaPresenter(View view){
        this.view = view;
        model = new example.kevin.retrofitexample.activity.noticia.model.NoticiaModel(this);


    }


    @Override
    public void doRegistrar(NoticiasModel noticiasModel) {
        model.doRegistrar(noticiasModel);


    }

    @Override
    public void showResult(String result) {

        view.showResult(result);
    }

    @Override
    public void showError(String error) {

        view.showError(error);
    }
}
