package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.beans.PersistenceDelegate;

public class EntityManagerService {
private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if(entityManagerFactory == null){
            create();
        }
        return entityManagerFactory;
    }
    public static void create(){
        entityManagerFactory= Persistence.createEntityManagerFactory("Marathon");
    }
    public static void close(){
        entityManagerFactory.close();
    }
}
