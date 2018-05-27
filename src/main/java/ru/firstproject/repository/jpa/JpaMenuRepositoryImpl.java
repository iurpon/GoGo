package ru.firstproject.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMenuRepositoryImpl implements MenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Menu> getAll() {
        return em.createNamedQuery(Menu.ALL_SORTED, Menu.class).getResultList();
    }
}
