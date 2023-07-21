package com.api.prescriptionmanager.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.api.prescriptionmanager.entities.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	public Optional<Patient> findById(int id);
//	@Query(value = "select * from prescription_manager.patient", nativeQuery=true)
//	public List<Patient> getPatient();
	
	@Query(value = "select * from prescription_manager.patient where patient_id =:id", nativeQuery=true)
	public Patient getPatientbyId(@Param("id") int id);

	
	@Query(value = "select * from prescription_manager.patient where name like concat('%' , :key , '%')", nativeQuery=true)
	public List<Patient> getPatientsbyKey(@Param("key") String key);
}
