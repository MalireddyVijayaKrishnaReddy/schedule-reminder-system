package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Category;
import com.project.schedulemanager.schedule_reminder_system.entity.Reminder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReminderDaoImpl implements ReminderDao {
@Autowired
    EntityManager entityManager;
    @Override
    public void add(Reminder reminder) {
        System.out.println("Adding..."+ LocalDateTime.now());

        entityManager.persist(reminder);
    }

    @Override
    public List<Reminder> getReminders(String username) {
        TypedQuery<Reminder> reminders = entityManager
                .createQuery(
                        "SELECT r FROM Reminder r WHERE r.username = :username", Reminder.class);

        reminders.setParameter("username", username);
        return reminders.getResultList();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Reminder.class, id));
    }

    @Override
    public void deleteAllRemindersOfCategory(String username, String categoryName) {
        entityManager.createQuery("DELETE FROM Reminder r WHERE r.category_name = :categoryName AND r.username=:username")
                .setParameter("categoryName", categoryName)
                .setParameter("username", username)
                .executeUpdate();
    }
}
