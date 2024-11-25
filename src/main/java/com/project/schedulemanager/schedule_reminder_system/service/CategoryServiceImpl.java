package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.dao.CategoryDao;
import com.project.schedulemanager.schedule_reminder_system.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ReminderService reminderService;


    @Override
    @Transactional
    public void addCategory(Category category) {
        if(!isCategoryPresent(category.getCategory_name())) {
            category.setUsername(UserService.getLoggedInUser());
            categoryDao.addCategory(category);
        }
    }

    @Override
    @Transactional
    public void removeCategory(String categoryName) {

        ///remove all tasks for this category
        reminderService.deleteAllRemindersOfCategory(categoryName);

        categoryDao.removeCategory(UserService.getLoggedInUser(),categoryName);
    }
    @Override
    public List<String> getAllCategories() {
        List<Category> categories= categoryDao.getAllCategories(UserService.getLoggedInUser());
        return categories.stream()
                .map(Category::getCategory_name)
                .toList();
    }

    public boolean isCategoryPresent(String categoryName) {

        return categoryDao.isCategoryExists(UserService.getLoggedInUser(),categoryName);
    }
}
