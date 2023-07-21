package com.api.prescriptionmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.prescriptionmanager.entities.Patient;
import com.api.prescriptionmanager.entities.Prescription;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer>{

	@Query(value = "select * from prescription_manager.prescription where pres_id =:pid", nativeQuery=true)
	public Prescription getPrescriptionbyId(@Param("pid") int pid);
	
	@Query(value = "select * from prescription_manager.prescription where patient_id =:id", nativeQuery=true)
	public List<Prescription> getPrescriptionforPatient(@Param("id") int id);

	@Query(value = "select Pr.* from prescription_manager.prescription Pr left join prescription_manager.patient Pt on Pt.patient_id = Pr.patient_id where Pt.name like concat('%' , :key, '%')", nativeQuery=true)
	public List<Prescription> getPrescriptionforPatientbyKey(@Param("key") String key);

}
