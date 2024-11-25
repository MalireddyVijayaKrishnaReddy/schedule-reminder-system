package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.entity.Category;
import com.project.schedulemanager.schedule_reminder_system.entity.Reminder;

import java.util.List;

public interface ReminderService {
    public void addReminder(Reminder reminder);
    public List<Reminder> getReminders();
    public void deleteReminder(int id);
    public void deleteAllRemindersOfCategory(String categoryName);
}
