package example.kevin.retrofitexample.activity.listar.presenter;

import java.util.List;

import example.kevin.retrofitexample.activity.listar.model.ListarModel;
import example.kevin.retrofitexample.activity.listar.model.Model;
import example.kevin.retrofitexample.activity.listar.view.View;
import example.kevin.retrofitexample.model.NoticiasModel;

/**
 * Created by KeChaval on 13/06/2018.
 */

public class ListarPresenter implements Presenter{

    View view;
    Model model;

    public ListarPresenter(View view){
        this.view=view;
        model = new ListarModel(this);
    }

    @Override
    public void showError(String error) {
        view.showError(error);
    }

    @Override
    public void getData(int idUsuario) {
        if (idUsuario>0){
            model.getData(idUsuario);
        }
    }

    @Override
    public void setData(List<NoticiasModel> list) {

        view.setData(list);

    }


}
