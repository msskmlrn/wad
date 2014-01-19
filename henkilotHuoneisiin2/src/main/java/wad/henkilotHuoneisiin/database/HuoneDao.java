package wad.henkilotHuoneisiin.database;

import java.util.List;
import wad.henkilotHuoneisiin.domain.Huone;

public interface HuoneDao extends DAO<Huone> {
    public List<Huone> list();
}
