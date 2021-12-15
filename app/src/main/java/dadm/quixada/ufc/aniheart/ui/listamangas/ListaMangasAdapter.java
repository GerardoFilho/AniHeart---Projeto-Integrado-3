package dadm.quixada.ufc.aniheart.ui.listamangas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dadm.quixada.ufc.aniheart.R;
import dadm.quixada.ufc.aniheart.data.model.Manga;

public class ListaMangasAdapter extends RecyclerView.Adapter<ListaMangasAdapter.ListaMangasViewHolder> {

    private List<Manga> mangas;
    private static ItemMangaClickListener itemMangaClickListener;

    public ListaMangasAdapter(ItemMangaClickListener itemMangaClickListener) {
        this.itemMangaClickListener = itemMangaClickListener;

        mangas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaMangasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga, parent, false);

        return new ListaMangasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaMangasViewHolder holder, int position) {
        holder.bind(mangas.get(position));
    }

    @Override
    public int getItemCount() {
        return (mangas != null && mangas.size() > 0) ? mangas.size() : 0;
    }

    static class ListaMangasViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloManga;
        private ImageView imagePosterManga;
        private Manga manga;

        public ListaMangasViewHolder(View itemView) {
            super(itemView);

            textTituloManga = itemView.findViewById(R.id.text_titulo_manga);
            imagePosterManga = itemView.findViewById(R.id.image_poster_manga);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemMangaClickListener != null) {
                       itemMangaClickListener.onItemMangaClicado(manga);
                    }
                }
            });
        }

        public void bind(Manga manga) {
            this.manga = manga;

            textTituloManga.setText(manga.getTitulo());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/" + manga.getCaminhoPoster())
                    .into(imagePosterManga);
        }
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
        notifyDataSetChanged();
    }

    public interface ItemMangaClickListener {

        void onItemMangaClicado(Manga manga);
    }
}
