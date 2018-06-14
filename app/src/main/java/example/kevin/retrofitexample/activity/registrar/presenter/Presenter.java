package example.kevin.retrofitexample.activity.registrar.presenter;

import example.kevin.retrofitexample.model.UsuarioModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public interface Presenter {

    void showResult(String result);

    void doRegistrar(UsuarioModel usuarioModel);

    void showError(String error);
}
