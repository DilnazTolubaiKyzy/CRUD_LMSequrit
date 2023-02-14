package com.peaksoft.crud_lmsequrit.service;

import com.peaksoft.crud_lmsequrit.entity.User;

import java.util.List;

public interface UserService {
    void save(User user,String roleName);
    void update(Long id, User user);
    User getById(Long id);
    List<User> getAll();
    User getUserByUserName(String username);
}
