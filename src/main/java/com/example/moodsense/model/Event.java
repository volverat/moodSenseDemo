package com.example.moodsense.model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.time.LocalDate;

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
 * Event Class
 */
@Entity
@Table(name="event")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class Event {
	
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_event;
	
	@Column
	private int id_user;
	
	@Column
	private int id_mood;
	
	@Column
	private Point coordinates;
	
	@Column
	private String date;
	
	//Constructor
	public Event() {}
	
	public Event(int id_user, int id_mood, Point coordinates) {
		this.id_user = id_user;
		this.id_mood = id_mood;
		this.coordinates = coordinates; //replace with the GoogleMaps APi coordinates
		this.date = LocalDate.now().toString();
		
	}
	
	//Setters and Getters
	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_mood() {
		return id_mood;
	}

	public void setId_mood(int id_mood) {
		this.id_mood = id_mood;
	}


	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates.getLocation();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = LocalDate.now().toString();
	}
	
}
