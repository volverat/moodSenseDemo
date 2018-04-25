package com.example.moodsense.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moodsense.model.User;

/**
 * @author victor olvera
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{

}
