package ru.firstproject.repository.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.firstproject.model.Menu;
import ru.firstproject.repository.MenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMenuRepositoryImpl implements MenuRepository {
    private static Logger logger = LoggerFactory.getLogger(JpaMenuRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Menu> getAll() {
        logger.debug("JpaMenuRepository getAll()");
        return em.createNamedQuery(Menu.ALL_SORTED, Menu.class).getResultList();
//        return em.createQuery("FROM MENU",Menu.class).getResultList();
    }

    @Override
    public List<Menu> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public Menu save(Menu menu) {
        return null;
    }
}
