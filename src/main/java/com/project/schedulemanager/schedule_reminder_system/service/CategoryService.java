package com.project.schedulemanager.schedule_reminder_system.service;

import com.project.schedulemanager.schedule_reminder_system.entity.Category;

import java.util.List;


public interface CategoryService {
    public void addCategory(Category category);

    public void removeCategory(String categoryName);

    public List<String> getAllCategories();
}
