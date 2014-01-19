package wad.varasto.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.varasto.domain.Henkilo;

@Repository
public class JPAHenkiloDao implements HenkiloDao {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Henkilo instance) {
        entityManager.merge(instance);
    }

    @Override
    public Henkilo read(int id) {
        return entityManager.find(Henkilo.class, id);
    }

    @Override
    public Henkilo update(Henkilo instance) {
        return entityManager.merge(instance);
    }

    @Override
    public void delete(Henkilo instance) {
        entityManager.remove(instance);
    }
    
    @Override
    public List<Henkilo> list() {
        Query q = entityManager.createQuery("SELECT h FROM Henkilo h");
        return q.getResultList();
    }
    
}