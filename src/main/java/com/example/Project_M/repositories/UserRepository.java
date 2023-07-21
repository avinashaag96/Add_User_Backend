package com.example.Project_M.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_M.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
