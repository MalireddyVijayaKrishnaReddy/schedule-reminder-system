package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Reminder;

import java.util.List;

public interface ReminderDao {
    public void add(Reminder reminder);
    public List<Reminder> getReminders(String username);
    public void delete(int id);
    public void deleteAllRemindersOfCategory(String username, String categoryName);
}
