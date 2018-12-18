package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.repository.UserJpaRepository;
import com.example.service.IUserService;

@Service
@Transactional

public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private BookRepository bookRepository;

//    @Cacheable(value = "users")
    public List<User> getAll()
    {
        return userJpaRepository.findAll();
    }
//    @Cacheable(value = "users")
//    public Iterable<Book> findAll()
//    {
//        return bookRepository.findAll();
//    }

    public User findById(Long id){
     return    userRepository.findById(id);
    }

    public List<User> findByName(String name)
    {
        List<User> userList1 = userRepository.findByName1(name);
        List<User> userList2 = userRepository.findByName2(name);
        List<User> userList3 = userRepository.findByNameAndAddress(name, "3");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }
//    @CachePut(value = "user",key = "#user.id")
    public void addUser(User user)
    {
        userJpaRepository.save(user);
//        bookRepository.save(book);

    }

    public List<User> init() {
        List<User> listUser = new ArrayList<>();
//        List<Book> listBook = new ArrayList<>();
        for(long i=0;i<11;i++){
            User user = new User();
//            Book book = new Book();
            user.setId(i);
//            book.setId(i);
            user.setName(i+"book-es");
//            book.setName(i+"book-es");
            user.setAddress(i+"xyq");
//            book.setAddress(i+"xyq");
            listUser.add(user);
//            listBook.add(book);
            userJpaRepository.save(user);
//            bookRepository.save(book);

        }
        return listUser;
    }

//    @Cacheable("users")
//    public User findOne(long id)
//    {
//        System.out.println("Cached Pages");
//        return userJpaRepository.findById(id);
//    }
//    @CacheEvict(value = "user",key = "#id")
    public void delete(User user)
    {
        userJpaRepository.delete(user);
//        bookRepository.delete(book);
    }
}
