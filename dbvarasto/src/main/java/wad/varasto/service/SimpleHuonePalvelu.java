package wad.varasto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.varasto.database.HuoneistoDao;
import wad.varasto.domain.Huone;

@Service
public class SimpleHuonePalvelu implements HuonePalvelu {
    
    @Autowired
    private HuoneistoDao huoneistoDao;
    
    @Override
    @Transactional
    public void lisaaHuone(Huone huone) {
        huoneistoDao.create(huone);
    }

    @Override
    @Transactional
    public void poistaHuone(int id) {
        Huone huone = huoneistoDao.read(id);
        if (huone != null) {
            huoneistoDao.delete(huone);
        }
    }

    @Override
    @Transactional
    public List<Huone> listaaHuoneet() {
        return huoneistoDao.list();
    }
    
}
