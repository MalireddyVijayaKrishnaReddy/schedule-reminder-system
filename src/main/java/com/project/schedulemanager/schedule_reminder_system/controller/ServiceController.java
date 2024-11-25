package com.project.schedulemanager.schedule_reminder_system.controller;

import com.project.schedulemanager.schedule_reminder_system.dao.UserDao;
import com.project.schedulemanager.schedule_reminder_system.entity.Category;
import com.project.schedulemanager.schedule_reminder_system.entity.Reminder;
import com.project.schedulemanager.schedule_reminder_system.service.CategoryService;
import com.project.schedulemanager.schedule_reminder_system.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ReminderService reminderService;

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String homePage(Model model) {
        List<String> categoryNames= categoryService.getAllCategories();
        List<Reminder> reminders = reminderService.getReminders();
        userDao.print();
        model.addAttribute("reminder",new Reminder());
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryNames);
        model.addAttribute("reminders", reminders);

        System.out.println(categoryService.getAllCategories());


        return "home-page";
    }
    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        category.setCategory_name(category.getCategory_name().toUpperCase());

        categoryService.addCategory(category);
        return "redirect:/";

    }
    @PostMapping("/deleteCategory/{categoryname}")
    public String deleteRecord(@PathVariable("categoryname") String categoryname) {
        categoryService.removeCategory(categoryname);
        System.out.println("trying to delete");
        return "redirect:/";
    }
    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("reminder") Reminder reminder, Model model) {
        System.out.println(reminder);
      reminderService.addReminder(reminder);

        return "redirect:/";
    }

    @PostMapping("/deleteReminder/{id}")
    public String deleteReminder(@PathVariable("id") int id) {
        reminderService.deleteReminder(id);
        return "redirect:/";
    }


}
