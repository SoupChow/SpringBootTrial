package com.api.prescriptionmanager.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@Column(name="patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	
	private String name;
	private String address;
	private long phoneNo;
	//private Date dob;
	
	
	public Patient(int patient_id, String name, String address, long phoneNo, Date dob) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		//this.dob = dob;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return patient_id;
	}
	public void setId(int id) {
		this.patient_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	@Override
	public String toString() {
		return "Patient [id=" + patient_id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo+"]";
	}

}
