package example.kevin.retrofitexample.activity.registrar.presenter;

import example.kevin.retrofitexample.activity.registrar.view.View;
import example.kevin.retrofitexample.activity.registrar.model.Model;
import example.kevin.retrofitexample.activity.registrar.model.RegistrarModel;
import example.kevin.retrofitexample.model.UsuarioModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class RegistrarPresenter implements Presenter{

    private Model model;
    private View view;

    public RegistrarPresenter(View view){

        this.view= view;
        model = new RegistrarModel(this);

    }


    @Override
    public void showResult(String result) {

        view.showResult(result);

    }

    @Override
    public void doRegistrar(UsuarioModel usuarioModel) {
        model.doRegistrar(usuarioModel);

    }

    @Override
    public void showError(String error) {

        view.showError(error);
    }
}
