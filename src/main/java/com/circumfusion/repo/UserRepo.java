package com.circumfusion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.circumfusion.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
