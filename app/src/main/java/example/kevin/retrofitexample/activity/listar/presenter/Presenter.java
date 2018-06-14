package example.kevin.retrofitexample.activity.listar.presenter;

import java.util.List;

import example.kevin.retrofitexample.model.NoticiasModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public interface Presenter {


    void showError(String error);
    void getData(int idUsuario);
    void setData(List<NoticiasModel> list);
}
