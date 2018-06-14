package example.kevin.retrofitexample.api;




import java.util.List;

import example.kevin.retrofitexample.api.request.LoginRequest;
import example.kevin.retrofitexample.api.request.NoticiaRequest;
import example.kevin.retrofitexample.api.request.UsuarioRequest;
import example.kevin.retrofitexample.api.response.LoginResponse;
import example.kevin.retrofitexample.api.response.NoticiaResponse;
import example.kevin.retrofitexample.api.response.UsuarioResponse;
import example.kevin.retrofitexample.model.NoticiasModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {




    @POST("api/login.php")
    Call<LoginResponse> doLogin(@Body LoginRequest request);

    @POST("api/register.php")
    Call<UsuarioResponse> doRegister(@Body UsuarioRequest request);

    @GET("api/noticia.php")
    Call<List<NoticiasModel>> getNoticias(@Query("idusuario") int idusuario);

    @POST("api/noticia.php")
    Call<NoticiaResponse> registerNoticia(@Body NoticiaRequest request);

}