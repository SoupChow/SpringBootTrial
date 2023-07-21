package com.api.prescriptionmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.prescriptionmanager.dao.PatientRepository;
import com.api.prescriptionmanager.dao.PrescriptionRepository;
import com.api.prescriptionmanager.entities.Patient;
import com.api.prescriptionmanager.entities.Prescription;

@Component
public class PresManagerService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public List<Patient> getAllPatients() {
		List<Patient> list = (List<Patient>) this.patientRepository.findAll();
		return list;
	}

	public Patient getPatientbyID(int id) {
		Patient patient = null;
		try{
			patient = this.patientRepository.getPatientbyId(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	public Patient addPatient(Patient patient) {
		Patient p= this.patientRepository.save(patient);
		return p;
	}
	
	public List<Prescription> getAllPrescriptions() {
		List<Prescription> list = (List<Prescription>) this.prescriptionRepository.findAll();
		return list;
	}

	public List<Prescription> getPrescription(int patient_id){
		List<Prescription> list = this.prescriptionRepository.getPrescriptionforPatient(patient_id);
		return list;
	}

	public Prescription addPrescription(Prescription prescription) {
		Prescription p= this.prescriptionRepository.save(prescription);
		return p;
	}

	public List<Prescription> getPrescriptionbyKey(String key) {
		List<Prescription> list = (List<Prescription>) this.prescriptionRepository.getPrescriptionforPatientbyKey(key);
		System.out.println("List = "+list);
		return list;
	}

	public List<Patient> getPatientbyKey(String key) {
		List<Patient> list = (List<Patient>) this.patientRepository.getPatientsbyKey(key);
		System.out.println("List = "+list);
		return list;
	}

	public void deletePatient(int pid) {
		this.patientRepository.deleteById(pid);
		
	}
	
}
