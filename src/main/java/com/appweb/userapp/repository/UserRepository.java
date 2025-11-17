package com.appweb.userapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appweb.userapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
