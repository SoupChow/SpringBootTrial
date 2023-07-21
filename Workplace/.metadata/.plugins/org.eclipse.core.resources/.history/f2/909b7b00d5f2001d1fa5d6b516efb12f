package com.api.prescriptionmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.prescriptionmanager.entities.Patient;
import com.api.prescriptionmanager.entities.Prescription;
import com.api.prescriptionmanager.service.PresManagerService;

@CrossOrigin("*")
@RestController
public class PresManagerController {
	
	@Autowired
	private PresManagerService presManagerService;
	
	//Getting all Patients
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getPatients(){
		List<Patient> list = this.presManagerService.getAllPatients();
		
		//Status code
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//Getting a single Patient
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
		Patient patient = this.presManagerService.getPatientbyID(id);
		if(patient==null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(patient));
	}

	//Adding a Patient
	@PostMapping("/patients")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient p =  null;
		try {
			p = this.presManagerService.addPatient(patient);
			System.out.println(p);
			return ResponseEntity.of(Optional.of(p));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Getting all prescriptions
	@GetMapping("/prescriptions")
	public ResponseEntity<List<Prescription>> getPrescriptions(){
		List<Prescription> list = this.presManagerService.getAllPrescriptions();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//Getting prescription for specific patient
	@GetMapping("/patients/prescriptions/{id}")
	public ResponseEntity<List<Prescription>> getPrescriptionforPatient(@PathVariable("id") int id) {
		List<Prescription> list = this.presManagerService.getPrescription(id);
		//Status code
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/prescriptions/{id}")
	public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription, @PathVariable("id") int id){
		Prescription p =  null;
		try {
			prescription.setPatient_id(id);
			p = this.presManagerService.addPrescription(prescription);
			System.out.println(p);
			return ResponseEntity.of(Optional.of(p));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/patients/prescriptions/search")
	public ResponseEntity<List<Prescription>> getPrescriptionforPatientUsingKey(@RequestParam("query") String query) {
		List<Prescription> list = this.presManagerService.getPrescriptionbyKey(query);
		//Status code
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/patients/search")
	public ResponseEntity<List<Patient>> getPatientbyKey(@RequestParam("query") String query) {
		System.out.println("Query = "+query);
		List<Patient> list = this.presManagerService.getPatientbyKey(query);
		//Status code
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@DeleteMapping("/patients/{pid}")
	public ResponseEntity<Void> deletePAtient(@PathVariable("pid") int pid) {
		try{
			this.presManagerService.deletePatient(pid);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
