package com.project.schedulemanager.schedule_reminder_system.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "Category")
public class Category {

    @Column(name="category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(name = "username")
    private String username;
    @Column(name = "category_name")
    private String category_name;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", username='" + username + '\'' +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
