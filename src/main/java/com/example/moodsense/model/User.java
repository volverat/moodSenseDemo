package com.example.moodsense.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author victor olvera
 * User POJO
 */
@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class User {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_user;
	
	@Column
	private String name;

	@Column
	private int age;
    
    
    //Constructor
    public User() {}
    
    //Constructor
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    
    //Methods
    public long getId_user() {
        return id_user;
    }
 
    public void setId_user(int id) {
        this.id_user = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
}
