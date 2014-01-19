package wad.henkilotHuoneisiin.service;

import java.util.List;
import wad.henkilotHuoneisiin.domain.Henkilo;

public interface HenkiloPalvelu {
    public void lisaa(Henkilo henkilo);
    public List<Henkilo> listaa();
    public void poista(String nimi);
    public Henkilo hae(String nimi);
    public void update(Henkilo henkilo);
}