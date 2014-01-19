package wad.elokuva.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.elokuva.database.ElokuvaDao;
import wad.elokuva.domain.Elokuva;

@Service
public class SimpleElokuvaPalvelu implements ElokuvaPalvelu {
    @Autowired
    ElokuvaDao elokuvaDao;
    
    @Override
    @Transactional
    public void lisaa(Elokuva elokuva) {
        elokuvaDao.create(elokuva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Elokuva> listaa() {
        return elokuvaDao.list();
    }

    @Override
    @Transactional
    public void paivita(Elokuva elokuva) {
        elokuvaDao.update(elokuva);
    }

    @Override
    public Elokuva hae(int elokuvaId) {
        return elokuvaDao.read(elokuvaId);
    }
    
}
