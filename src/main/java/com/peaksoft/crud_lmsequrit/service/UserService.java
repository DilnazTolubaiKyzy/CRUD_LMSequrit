package com.peaksoft.crud_lmsequrit.service;

import com.peaksoft.crud_lmsequrit.entity.Role;
import com.peaksoft.crud_lmsequrit.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void save(User user,String roleName);
    void update(Long id, User user,String roleName);
    User getById(Long id);
    List<User> getAll();
    User getUserByEmail(String email);

    Set<Role> getRolesByUserId(Long id);
    void delete(User user);
}
