package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Authority;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AuthorityDao {

    private final EntityManager entityManager;

    @Autowired
    public AuthorityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveAuthority(String username, String authority) {
        Authority authorityEntity = new Authority(username, authority);
        entityManager.persist(authorityEntity);
    }
}
