package wad.elokuva.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.elokuva.database.GenreDao;
import wad.elokuva.domain.Genre;

@Service
public class SimpleGenrePalvelu implements GenrePalvelu {
    
    @Autowired
    GenreDao genreDao;
    
    @Override
    @Transactional
    public void lisaa(Genre genre) {
        genreDao.create(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> listaa() {
        return genreDao.list();
    }

    @Override
    @Transactional
    public void paivita(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    public Genre hae(String nimi) {
        return genreDao.read(nimi);
    }
    
}
