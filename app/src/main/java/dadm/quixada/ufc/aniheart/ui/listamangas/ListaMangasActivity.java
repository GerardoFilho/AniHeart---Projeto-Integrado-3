package dadm.quixada.ufc.aniheart.ui.listamangas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import dadm.quixada.ufc.aniheart.R;
import dadm.quixada.ufc.aniheart.data.model.Manga;
import dadm.quixada.ufc.aniheart.ui.detalhesmanga.DetalhesMangaActivity;

public class ListaMangasActivity extends AppCompatActivity
        implements ListaMangasContrato.ListaMangasView,
        ListaMangasAdapter.ItemMangaClickListener {

    private ListaMangasAdapter mangasAdapter;
    private ListaMangasContrato.ListaMangasPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lista_mangas);

        configuraToolbar();

        configuraAdapter();

        presenter = new ListaMangasPresenter(this);
        presenter.obtemMangas();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        final RecyclerView recyclerMangas = findViewById(R.id.recycler_mangas);

        mangasAdapter = new ListaMangasAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerMangas.setLayoutManager(gridLayoutManager);
        recyclerMangas.setAdapter(mangasAdapter);
    }

    @Override
    public void mostraMangas(List<Manga> mangas) {
        mangasAdapter.setMangas(mangas);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de mangas.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void onItemMangaClicado(Manga manga) {
        Intent intent = new Intent(this, DetalhesMangaActivity.class);
        intent.putExtra(DetalhesMangaActivity.EXTRA_MANGA, manga);
        startActivity(intent);
    }
}
