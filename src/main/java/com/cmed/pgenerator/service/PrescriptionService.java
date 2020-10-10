package com.cmed.pgenerator.service;

import com.cmed.pgenerator.entity.Prescription;
import com.cmed.pgenerator.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(int id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    public Prescription getPrescriptionByPatientName(String patientName) {
        return prescriptionRepository.findByPatientName(patientName);
    }

    public void deletePrescription(int id) {
        prescriptionRepository.deleteById(id);
    }

}
