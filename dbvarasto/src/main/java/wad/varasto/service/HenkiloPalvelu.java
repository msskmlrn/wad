package wad.varasto.service;

import java.util.List;
import wad.varasto.domain.Henkilo;

public interface HenkiloPalvelu {
    public void lisaaHenkilo(Henkilo henkilo);
    public void poistaHenkilo(int id);
    public List<Henkilo> listaaHenkilot();
}