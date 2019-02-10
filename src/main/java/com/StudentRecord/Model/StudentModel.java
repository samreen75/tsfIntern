package com.StudentRecord.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	
	private long id ;
	 @Column(name= " Name")
	 
	 private String name;
	 
@Column(name= "address")
	 
	 private String address;
	 
	 
 public StudentModel() {
		 
	 }

	 public StudentModel(long id , String name , String address) {
		 this.id= id;
		 this.name=name;
		 this.address=address;
	 }
	 
	 public long getId() {
		 return id;
	 }
	 
	 public void setId(long id) {
		 this.id=id;

	 }
	 

	 public String getName() {
		 return name;
	 }
	 
	 public void setName(String name) {
		 this.name=name;

	 }
	 
	 public String getAddress() {
		 return address;
	 }
	 
	 public void setAddress(String address) {
		 this.address=address;

	 }

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}



}
