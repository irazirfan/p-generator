package com.cmed.pgenerator.controller;

import com.cmed.pgenerator.entity.Prescription;
import com.cmed.pgenerator.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PrescriptionRestController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    @GetMapping("/prescriptionList")
    public List<Prescription> prescriptions() {
        return prescriptionService.getPrescriptions();
    }
}
