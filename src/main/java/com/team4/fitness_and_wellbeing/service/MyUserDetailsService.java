package com.team4.fitness_and_wellbeing.service;


import com.team4.fitness_and_wellbeing.Dao.UserDao;
import com.team4.fitness_and_wellbeing.Login.UserRepository;
import com.team4.fitness_and_wellbeing.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User with this username no found: " + username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserDto getCurrentUserProfileInfo(String username) throws UsernameNotFoundException{
        UserDao currentUser = userDao.findByUsername(username);
        return new UserDto(currentUser.getId(), currentUser.getUsername(),currentUser.getFull_name(), currentUser.getUser_type());
    }

    public UserDao save(UserDto user){
        UserDao newUser = new UserDao();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setFull_name(user.getFull_name());
        newUser.setUser_type(user.getUser_type());
        return userDao.save(newUser);
    }
}
