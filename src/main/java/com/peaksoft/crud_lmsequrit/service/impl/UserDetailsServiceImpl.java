package com.peaksoft.crud_lmsequrit.service.impl;

import com.peaksoft.crud_lmsequrit.entity.MyUser;
import com.peaksoft.crud_lmsequrit.entity.User;
import com.peaksoft.crud_lmsequrit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return new MyUser(user);
    }
}
