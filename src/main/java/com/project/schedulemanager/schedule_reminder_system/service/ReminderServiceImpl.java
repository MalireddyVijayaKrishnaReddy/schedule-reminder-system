package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.dao.ReminderDao;
import com.project.schedulemanager.schedule_reminder_system.entity.Category;
import com.project.schedulemanager.schedule_reminder_system.entity.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {
    private static final String REMINDER_SENT_FALSE="N";

    @Autowired
    ReminderDao reminderDao;

    @Transactional
    @Override
    public void addReminder(Reminder reminder) {

        reminder.setReminder_sent(REMINDER_SENT_FALSE);
        reminder.setUsername(UserService.getLoggedInUser());
        reminderDao.add(reminder);
    }

    @Override
    public List<Reminder> getReminders() {
        return reminderDao.getReminders(UserService.getLoggedInUser());
    }


    @Override
    @Transactional
    public void deleteReminder(int id) {
         reminderDao.delete(id);
    }

    @Override
    public void deleteAllRemindersOfCategory(String category) {
        reminderDao.deleteAllRemindersOfCategory(UserService.getLoggedInUser(), category);
    }
}
