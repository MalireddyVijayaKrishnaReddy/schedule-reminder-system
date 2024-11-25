package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.dao.AuthorityDao;
import com.project.schedulemanager.schedule_reminder_system.dao.UserDao;
import com.project.schedulemanager.schedule_reminder_system.dao.DemoGraphicsDao;
import com.project.schedulemanager.schedule_reminder_system.dto.SignUpDto;
import com.project.schedulemanager.schedule_reminder_system.entity.Demographics;
import com.project.schedulemanager.schedule_reminder_system.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
public class SignUpService {
    UserDao userDao;
    DemoGraphicsDao demoGraphicsDao;
    AuthorityDao authorityDao;

    SignUpService(UserDao userDao, DemoGraphicsDao demoGraphicsDao, AuthorityDao authorityDao) {
        this.userDao = userDao;
        this.demoGraphicsDao = demoGraphicsDao;
        this.authorityDao = authorityDao;
    }


    @Transactional
    public void registerUser(SignUpDto signUpDto, Model model) {
        if(doUserExists(signUpDto.getUsername())) {
            model.addAttribute("userExists", true);
            return;
        }
        model.addAttribute("userExists", false);
        Demographics demographics = new Demographics();
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setPassword(signUpDto.getPassword());
        user.setEnabled((short) 1);
        userDao.addUser(user);

        demographics.setUsername(signUpDto.getUsername());
        demographics.setFirstname(signUpDto.getFirstname());
        demographics.setLastname(signUpDto.getLastname());
        demographics.setPhone_number(signUpDto.getPhone_number());
        demoGraphicsDao.add(demographics);


        authorityDao.saveAuthority(signUpDto.getUsername(), "ROLE_EMPLOYEE");

    }
    public boolean doUserExists(String username){
        return userDao.checkUserExists(username);
    }
}
