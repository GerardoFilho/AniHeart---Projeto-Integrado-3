package dadm.quixada.ufc.aniheart.ui.detalhesmanga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dadm.quixada.ufc.aniheart.R;
import dadm.quixada.ufc.aniheart.data.model.Manga;

public class DetalhesMangaActivity extends AppCompatActivity {

    public static final String EXTRA_MANGA = "EXTRA_MANGA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_manga);

        TextView textTituloManga = findViewById(R.id.text_titulo_manga);

        final Manga manga = (Manga) getIntent().getSerializableExtra(EXTRA_MANGA);

        textTituloManga.setText(manga.getTitulo());
    }
}
