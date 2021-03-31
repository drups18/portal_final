package com.mv.release.repository;

import com.mv.release.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "select email from users where username =?1 and podid=?2", nativeQuery = true)
    public String  findbyqaname(String employeename,Long podid);

}
