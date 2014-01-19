package wad.elokuva.database;

import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wad.elokuva.domain.Elokuva;

@Repository
public class JPAElokuvaDao implements ElokuvaDao {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Elokuva> list() {
        Query q = entityManager.createQuery("SELECT e FROM Elokuva e");
        return q.getResultList();
    }

    @Override
    public Elokuva read(int elokuvaId) {
        return entityManager.find(Elokuva.class, elokuvaId);
    }

    @Override
    public void create(Elokuva instance) {
        entityManager.merge(instance);
    }

    @Override
    public Elokuva update(Elokuva instance) {
        return entityManager.merge(instance);
    }

    @Override
    public void delete(Elokuva instance) {
        entityManager.remove(instance);
    }
}
