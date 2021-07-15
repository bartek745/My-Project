package org.example;

import javax.persistence.EntityManager;
import javax.persistence.SynchronizationType;
import java.util.List;

public class RunnerDAO {

    public void addRunner(Runner runner) {

        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(runner);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Runner> getAll() {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        List<Runner> list = entityManager.createQuery("from Runner ", Runner.class).getResultList();
        entityManager.close();
        return list;

    }


    List<Runner> winner() {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        List<Runner> list1 = entityManager.createQuery("from Runner ", Runner.class).getResultList();
        entityManager.close();
        return list1;


    }

}

