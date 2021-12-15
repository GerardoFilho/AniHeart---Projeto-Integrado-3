package dadm.quixada.ufc.aniheart.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class MangasResult {

    @Json(name = "results")
    private final List<MangaResponse> resultadoMangas;

    public MangasResult(List<MangaResponse> resultadoMangas) {
        this.resultadoMangas = resultadoMangas;
    }

    public List<MangaResponse> getResultadoMangas() {
        return resultadoMangas;
    }
}
