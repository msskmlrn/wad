package wad.varasto.database;

import java.util.List;
import wad.varasto.domain.Henkilo;

public interface HenkiloDao extends DAO<Henkilo> {
    public List<Henkilo> list();
}