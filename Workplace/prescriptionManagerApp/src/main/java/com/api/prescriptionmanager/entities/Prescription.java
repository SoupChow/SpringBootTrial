package com.api.prescriptionmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {

	@Id
	@Column(name="pres_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pres_id;
	
	private int patient_id;
	private String bloodPressure;
	private String sugarLvl;
	private String age;
	
	private String med[];		//Medicine name
	private String dosage[];	//1 capsule
	private String format[]; 	//1-0-1	
	
	
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getPres_id() {
		return pres_id;
	}
	public void setPres_id(int pres_id) {
		this.pres_id = pres_id;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getSugarLvl() {
		return sugarLvl;
	}
	public void setSugarLvl(String sugarLvl) {
		this.sugarLvl = sugarLvl;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String[] getMed() {
		return med;
	}
	public void setMed(String[] med) {
		this.med = med;
	}
	public String[] getDosage() {
		return dosage;
	}
	public void setDosage(String[] dosage) {
		this.dosage = dosage;
	}
	public String[] getFormat() {
		return format;
	}
	public void setFormat(String[] format) {
		this.format = format;
	}
	
	
	
	
}
