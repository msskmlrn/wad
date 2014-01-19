package wad.henkilotHuoneisiin.database;

import java.util.List;
import wad.henkilotHuoneisiin.domain.Henkilo;

public interface HenkiloDao extends DAO<Henkilo> {
    public List<Henkilo> list();
    
    public Henkilo read(String nimi);
}