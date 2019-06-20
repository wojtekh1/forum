package com.handel.forum.repository;

import com.handel.forum.model.ForumUsers;
import com.handel.forum.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<ForumUsers, Integer> {
    ForumUsers findByEmail(String email);

    @Query(value = "select * from ForumUsers", nativeQuery = true)
    List<ForumUsers> findAllUsers();

    List<ForumUsers> findUserByRoles(UserType role);

    ForumUsers findUsersByUserId(Integer id);


}