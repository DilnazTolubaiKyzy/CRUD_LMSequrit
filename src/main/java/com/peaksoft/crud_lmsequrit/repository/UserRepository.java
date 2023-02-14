package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username = :username")
    User getUserByUserName(@Param("username") String username);

}
