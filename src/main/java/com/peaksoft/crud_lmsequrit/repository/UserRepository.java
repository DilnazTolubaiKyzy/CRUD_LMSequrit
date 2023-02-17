package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Role;
import com.peaksoft.crud_lmsequrit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.email = :email")
    User getUserByEmail(@Param("email") String email);
    @Query("select r from Role r join r.users u where u.id=:id")
    Set<Role> getRolesByUserId(@Param("id") Long id);
}
