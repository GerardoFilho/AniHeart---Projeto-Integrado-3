package dadm.quixada.ufc.aniheart.ui.listamangas;

import java.util.List;

import dadm.quixada.ufc.aniheart.data.mapper.MangaMapper;
import dadm.quixada.ufc.aniheart.data.model.Manga;
import dadm.quixada.ufc.aniheart.data.network.ApiService;
import dadm.quixada.ufc.aniheart.data.network.response.MangasResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaMangasPresenter implements ListaMangasContrato.ListaMangasPresenter {

    private ListaMangasContrato.ListaMangasView view;

    public ListaMangasPresenter(ListaMangasContrato.ListaMangasView view) {
        this.view = view;
    }

    @Override
    public void obtemMangas() {
        ApiService.getInstance()
                .obterMangasApi("14eccca2f4f59c89f4ea7ed06fd384d1")
                .enqueue(new Callback<MangasResult>() {
                    @Override
                    public void onResponse(Call<MangasResult> call, Response<MangasResult> response) {
                        if (response.isSuccessful()) {
                            final List<Manga> listaMangas = MangaMapper
                                    .deResponseParaDominio(response.body().getResultadoMangas());

                            view.mostraMangas(listaMangas);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<MangasResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
