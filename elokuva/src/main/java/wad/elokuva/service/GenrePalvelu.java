package wad.elokuva.service;

import java.util.List;
import wad.elokuva.domain.Genre;

public interface GenrePalvelu {
    public void lisaa(Genre genre);
    public List<Genre> listaa();
    public void paivita(Genre genre);
    public Genre hae(String nimi);
}
