package dadm.quixada.ufc.aniheart.data.mapper;

import java.util.ArrayList;
import java.util.List;

import dadm.quixada.ufc.aniheart.data.model.Manga;
import dadm.quixada.ufc.aniheart.data.network.response.MangaResponse;

public class MangaMapper {

    public static List<Manga> deResponseParaDominio(List<MangaResponse> listaMangaResponse) {
        List<Manga> listaMangas = new ArrayList<>();

        for (MangaResponse mangaResponse : listaMangaResponse) {
            final Manga manga = new Manga(mangaResponse.getTituloOriginal(), mangaResponse.getCaminhoPoster());
            listaMangas.add(manga);
        }

        return listaMangas;
    }
}
