package com.its4u.rest.client;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;  

/*
 Panache will help to manage Entities 
All entity attributes have to be public, and you don’t need to provide any getter or setter methods
It generate an Id using a internal methode. Id will be called id
It give access to jpa methode like findById
*/
@Entity
@Cacheable
public class User extends PanacheEntity {

    public String name;

    public User(){}

    public User(String name){ 
        this.name = name;
    }

}