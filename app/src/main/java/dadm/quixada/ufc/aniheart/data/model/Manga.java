package dadm.quixada.ufc.aniheart.data.model;

import java.io.Serializable;

public class Manga implements Serializable {

    private final String titulo;
    private final String caminhoPoster;

    public Manga(String titulo, String caminhoPoster) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
