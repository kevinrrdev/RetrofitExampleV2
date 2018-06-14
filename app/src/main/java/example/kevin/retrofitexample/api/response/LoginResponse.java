package example.kevin.retrofitexample.api.response;

import example.kevin.retrofitexample.model.UsuarioModel;

public class LoginResponse {


    boolean success;
    String message;
    UsuarioModel usuario;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
