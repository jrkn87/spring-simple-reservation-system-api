package pl.jrkn87.reservationsystem.domain.guest;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GuestRepositoryOldImpl implements GuestRepository {
    //CRUD

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Guest guest) {
        entityManager.persist(guest);
    }

    @Override
    @Transactional
    public void update(Guest guest) {
        entityManager.merge(guest);
    }

    @Override
    public Guest findById(long id) {
        return entityManager.find(Guest.class, id);
    }

    @Override
    public List<Guest> getAll() {
        return entityManager
                .createQuery("SELECT guest FROM Guest guest", Guest.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(Guest guest) {
        entityManager.remove(guest);
    }
}
