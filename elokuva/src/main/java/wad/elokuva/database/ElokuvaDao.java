package wad.elokuva.database;

import java.util.List;
import wad.elokuva.domain.Elokuva;

public interface ElokuvaDao extends DAO<Elokuva> {
    public List<Elokuva> list();
    public Elokuva read(int elokuvaId);
}
