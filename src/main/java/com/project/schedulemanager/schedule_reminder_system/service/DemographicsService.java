package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.dao.DemoGraphicsDao;
import com.project.schedulemanager.schedule_reminder_system.entity.Demographics;
import org.springframework.stereotype.Service;

@Service
public class DemographicsService {
    DemoGraphicsDao demoGraphicsDao;
    DemographicsService(DemoGraphicsDao demoGraphicsDao) {
        this.demoGraphicsDao = demoGraphicsDao;
    }
    public Demographics getDemographics() {
        return demoGraphicsDao.getDemographics(UserService.getLoggedInUser());
    }
}
