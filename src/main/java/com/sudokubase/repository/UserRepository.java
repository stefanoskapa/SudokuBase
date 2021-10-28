package com.sudokubase.repository;

import com.sudokubase.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    public Users findByEmailIgnoreCase(String email);
    public Users findByUsernameIgnoreCase(String username);

   
}