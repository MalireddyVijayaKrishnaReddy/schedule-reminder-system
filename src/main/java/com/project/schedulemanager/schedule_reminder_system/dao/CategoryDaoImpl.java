package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private EntityManager entityManager;

    @Override

    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override

    public void removeCategory(String username, String categoryName) {
        entityManager.createQuery("DELETE FROM Category c WHERE c.category_name = :categoryName AND c.username=:username")
                .setParameter("categoryName", categoryName)
                .setParameter("username", username)
                .executeUpdate();
    }

    @Override
    public List<Category> getAllCategories(String username) {
        TypedQuery<Category> categories = entityManager
                                          .createQuery(
                                                  "SELECT c FROM Category c WHERE c.username = :username", Category.class);
        categories.setParameter("username", username);
        return categories.getResultList();
    }

    @Override
    public boolean isCategoryExists(String user, String category_name) {
        TypedQuery<Category> category = entityManager
                .createQuery(
                        "SELECT c FROM Category c WHERE c.username = :username AND c.category_name= :category_name", Category.class);
        category.setParameter("username", user);
        category.setParameter("category_name", category_name);
        return !category.getResultList().isEmpty();

    }
}
