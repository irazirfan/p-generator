package com.cmed.pgenerator.repository;

import com.cmed.pgenerator.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {

    Prescription findByPatientName(String patientName);
}
