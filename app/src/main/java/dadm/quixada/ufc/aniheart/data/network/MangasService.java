package dadm.quixada.ufc.aniheart.data.network;

import dadm.quixada.ufc.aniheart.data.network.response.MangasResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MangasService {

    @GET("movie/popular")
    Call<MangasResult> obterMangasApi(@Query("api_key") String chaveApi);
}
