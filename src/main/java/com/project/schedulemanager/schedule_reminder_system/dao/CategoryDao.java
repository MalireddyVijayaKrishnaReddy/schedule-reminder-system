package com.project.schedulemanager.schedule_reminder_system.dao;

import com.project.schedulemanager.schedule_reminder_system.entity.Category;

import java.util.List;

public interface CategoryDao {
    public void addCategory(Category category);
    public void removeCategory(String user, String category_name);
    public List<Category> getAllCategories(String username);
    public boolean isCategoryExists(String user, String category_name);
}
