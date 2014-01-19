package wad.elokuva.database;

import java.util.List;
import wad.elokuva.domain.Genre;

public interface GenreDao extends DAO<Genre> {
    public List<Genre> list();
    public Genre read(String nimi);
}
