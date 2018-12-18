package com.example.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add/{id}/{name}/{address}",method =RequestMethod.POST)
    public User addUser(@PathVariable Long id, @PathVariable String name,
        @PathVariable String address)
    {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        userService.addUser(user);
        return user;
    }
    @RequestMapping(value = "/mutl-add",method =RequestMethod.POST)
    public List<User> init(){
        return userService.init();
}
//    @RequestMapping(value = "/delete/{id}")
//    public void deleteBook(@PathVariable int id)
//    {
//        userService.delete(id);
//    }

    @RequestMapping(value = "/findid/{id}",method =RequestMethod.GET)
    public User find(@PathVariable Long id){
        return userService.findById(id);
    }


    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public List<User> getUsers()
    {
        return userService.getAll();
    }


//        @RequestMapping(value = "/",method = RequestMethod.GET)
//        public Iterable<Book> getBooks()
//    {
//        return userService.findAll();
//    }

//    @RequestMapping(value = "/{id}")
//    public User getUser(@PathVariable int id)
//    {
//        User user = userService.findOne(id);
//        return user;
//    }

    @RequestMapping(value = "/search/name/{name}",method = RequestMethod.GET)
    public List<User> getBookByName(@PathVariable String name)
    {
        List<User> users = userService.findByName(name);
        return users;
    }




}
