package org.example;

import javax.persistence.EntityManager;
import java.util.List;

public class RunDAO {


    public List<Run> getAll() {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        List<Run> runs = entityManager.createQuery("from Run",Run.class).getResultList();
        entityManager.close();
        return runs;

    }
}
