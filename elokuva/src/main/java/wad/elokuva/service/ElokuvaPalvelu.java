package wad.elokuva.service;

import java.util.List;
import wad.elokuva.domain.Elokuva;

public interface ElokuvaPalvelu {
    public void lisaa(Elokuva elokuva);
    public List<Elokuva> listaa();
    public void paivita(Elokuva elokuva);
    public Elokuva hae(int elokuvaId);
}
