package example.kevin.retrofitexample.activity.login.presenter;

import example.kevin.retrofitexample.activity.login.model.LoginModel;
import example.kevin.retrofitexample.activity.login.model.Model;
import example.kevin.retrofitexample.activity.login.view.View;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class LoginPresenter implements Presenter {

    private View view;
    private Model model;

    public LoginPresenter(View view){
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void showResultLogin(String result) {

        view.showResultLogin(result);

    }

    @Override
    public void doLogin(String usuario, String password) {
        if (view!=null){

            if (validate(usuario,password)){
                model.doLogin(usuario,password);
            }
            else
                return;

        }

    }

    public boolean validate(String usuario, String password) {

        boolean valid = true;
        String msgError;

        if(usuario.isEmpty()){
            msgError="Por favor ingrese un usuario.";
            view.showErrorLogin(msgError);
            valid = false;
        }
        if (password.isEmpty() || password.length() < 6 || password.length() > 15 ) {
            msgError ="La contraseña debe tener entre 6 y 15 caracteres alfanuméricos.";
            view.showErrorLogin(msgError);
            valid = false;
        }

        return valid;
    }

    @Override
    public void showErrorLogin(String error) {

        view.showErrorLogin(error);

    }
}
