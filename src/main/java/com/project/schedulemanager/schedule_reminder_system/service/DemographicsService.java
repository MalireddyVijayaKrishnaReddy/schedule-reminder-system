package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.dao.DemoGraphicsDao;
import com.project.schedulemanager.schedule_reminder_system.entity.Demographics;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemographicsService {
    DemoGraphicsDao demoGraphicsDao;
    DemographicsService(DemoGraphicsDao demoGraphicsDao) {
        this.demoGraphicsDao = demoGraphicsDao;
    }
    public Demographics getDemographics() {
        return demoGraphicsDao.getDemographics(UserService.getLoggedInUser());
    }
    @Transactional
    public void updateDemographics(Demographics demographics) {
        demoGraphicsDao.update(demographics);
    }
}
