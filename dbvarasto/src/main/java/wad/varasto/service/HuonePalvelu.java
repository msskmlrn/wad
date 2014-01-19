package wad.varasto.service;

import java.util.List;
import wad.varasto.domain.Huone;

public interface HuonePalvelu {
    public void lisaaHuone(Huone huone);
    public void poistaHuone(int id);
    public List<Huone> listaaHuoneet();
}
