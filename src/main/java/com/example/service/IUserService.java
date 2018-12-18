package com.example.service;

import java.util.List;

import com.example.domain.User;

public interface IUserService
{
//    public Iterable<Book> findAll();

    public void addUser(User user);

    public User findById(Long id);
    public List<User> getAll();

    public void delete(User user);

    public List<User> findByName(String name);

    List<User> init();





}
