package com.its4u.rest.client;

import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;  // Panache will help to manage Entities 

/*
 Panache will help to manage Entities 
All entity attributes have to be public, and you don’t need to provide any getter or setter methods
It generate an Id using a internal methode. Id will be called "id". User object will be created as user_id
It give access to jpa methode like findById
*/

@Entity
@Cacheable
public class Message extends PanacheEntity {

	//@Column(name = "texte",length = 500)
    public String texte;
	
	//@Column(name = "creation_date", nullable = false, updatable = false)
	//@Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime creationDate;
	
	//@Column()
	@ManyToOne (cascade = CascadeType.MERGE)
    public User user;
	

}