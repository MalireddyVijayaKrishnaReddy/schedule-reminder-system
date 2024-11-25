package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    EntityManager entityManager;
    UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  boolean checkUserExists(String username) {
        TypedQuery<User> query= entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
       return  !query.getResultList().isEmpty();

    }

    public void addUser(User user) {
        entityManager.persist(user);
    }
    public void print(){
        TypedQuery<User> query= entityManager.createQuery("SELECT u FROM User u ", User.class);
        System.out.println("all users"+query.getResultList());
    }
}

