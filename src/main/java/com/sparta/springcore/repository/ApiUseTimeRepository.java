package com.sparta.springcore.repository;

import com.sparta.springcore.model.ApiUseTime;
import com.sparta.springcore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ApiUseTimeRepository extends JpaRepository<ApiUseTime, Long> {

    Optional<ApiUseTime> findByUser(User user);
}
