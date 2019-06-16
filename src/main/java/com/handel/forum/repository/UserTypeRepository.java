package com.handel.forum.repository;

import com.handel.forum.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userTypeRepository")
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

    UserType findByUserType(String type);

    @Query(value = "select * from User_Type", nativeQuery = true)
    List<UserType> findAllRoles();
}
