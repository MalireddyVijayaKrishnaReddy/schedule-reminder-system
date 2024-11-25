package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Demographics;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class DemoGraphicsDao {
    EntityManager entityManager;
    DemoGraphicsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void add(Demographics demographics) {
        entityManager.persist(demographics);
    }
    public Demographics getDemographics(String username) {
         TypedQuery<Demographics> query =  entityManager.createQuery("Select D from Demographics D where D.username = :username", Demographics.class);
         query.setParameter("username", username);
         return query.getSingleResult();
    }
}
