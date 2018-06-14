package example.kevin.retrofitexample.model;

public class NoticiasModel {
    int idnoticia;
    String noticia,lugar;
    UsuarioModel usuario;

    public int getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(int idnoticia) {
        this.idnoticia = idnoticia;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
