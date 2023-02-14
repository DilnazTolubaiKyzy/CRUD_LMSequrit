package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Role;
import com.peaksoft.crud_lmsequrit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("select r from Role r where r.roleName = :roleName")
    Role getUserByRoleName(@Param("roleName") String roleName);
}
