package example.kevin.retrofitexample.activity.listar.view;

import java.util.List;

import example.kevin.retrofitexample.model.NoticiasModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public interface View {


    void showError(String error);
    void setData(List<NoticiasModel> list);
}
