package dadm.quixada.ufc.aniheart.ui.listamangas;

import java.util.List;

import dadm.quixada.ufc.aniheart.data.model.Manga;

public interface ListaMangasContrato {

    interface ListaMangasView {

        void mostraMangas(List<Manga> mangas);

        void mostraErro();
    }

    interface ListaMangasPresenter {

        void obtemMangas();

        void destruirView();
    }
}
