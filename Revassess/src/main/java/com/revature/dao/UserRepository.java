package com.revature.dao;

import com.revature.model.User;

import java.util.Set;

public class UserRepository implements CrudRepository<User>{

    public User findUserByUsername(String username){
        return null;
    }

    public User findUserByCredentials(String username, String pw){
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}