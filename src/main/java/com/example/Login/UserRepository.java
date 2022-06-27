package com.example.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<UserRegisterEntity, Long> {

    List<UserRegisterEntity> findAll();
}
