package wad.varasto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.varasto.database.HenkiloDao;
import wad.varasto.domain.Henkilo;

@Service
public class SimpleHenkiloPalvelu implements HenkiloPalvelu {
    
    @Autowired
    private HenkiloDao henkiloDao;
    
    @Override
    @Transactional
    public void lisaaHenkilo(Henkilo henkilo) {
        henkiloDao.create(henkilo);
    }

    @Override
    @Transactional
    public void poistaHenkilo(int id) {
        Henkilo henkilo = henkiloDao.read(id);
        if (henkilo != null) {
            henkiloDao.delete(henkilo);
        }
    }

    @Override
    @Transactional
    public List<Henkilo> listaaHenkilot() {
        return henkiloDao.list();
    }
    
}