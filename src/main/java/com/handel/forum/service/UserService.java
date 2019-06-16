package com.handel.forum.service;


import com.handel.forum.model.ForumUsers;
import com.handel.forum.model.UserType;
import com.handel.forum.repository.UserTypeRepository;
import com.handel.forum.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Service("userService")
public class UserService {

    private UsersRepository usersRepository;
    private UserTypeRepository userTypeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UsersRepository usersRepository,
                       UserTypeRepository userTypeRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.userTypeRepository = userTypeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ForumUsers findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public List<UserType> findAllTypes() {
        return userTypeRepository.findAllRoles();
    }

    public ForumUsers saveNewUser(ForumUsers user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setIsActive(1);

        return usersRepository.save(user);
    }

    public ForumUsers updateUser(ForumUsers user){
        return usersRepository.save(user);
    }


    public List<ForumUsers> findUserByRoles(UserType role) {
        return usersRepository.findUserByRoles(role);

    }


    public List<ForumUsers> findAll() {
        return usersRepository.findAll();

    }

    public ForumUsers findUsersByUserId(Integer id) {
        return usersRepository.findUsersByUserId(id);
    }

}