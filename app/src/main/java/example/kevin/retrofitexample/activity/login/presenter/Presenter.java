package example.kevin.retrofitexample.activity.login.presenter;

/**
 * Created by KeChaval on 13/06/2018.
 */

public interface Presenter {

    void showResultLogin(String result);

    void doLogin(String usuario, String password);

    void showErrorLogin(String error);
}
