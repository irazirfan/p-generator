package com.cmed.pgenerator.controller;

import com.cmed.pgenerator.entity.Prescription;
import com.cmed.pgenerator.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping("/")
    public String viewIndex(Model model) {
        List<Prescription> prescriptionList = prescriptionService.getPrescriptions();
        model.addAttribute("prescriptionList", prescriptionList);
        return "index";
    }

    @RequestMapping("/addNewPrescription")
    public String viewAddNewForm(Model model) {
        Prescription prescription = new Prescription();
        model.addAttribute("prescription", prescription);
        return "addNew";
    }

    @RequestMapping("/save")
    public String savePrescription(@ModelAttribute("prescription") Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "redirect:/";
    }

    @RequestMapping("/prescription/{id}")
    public ModelAndView showEditPrescription(@PathVariable(name= "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Prescription existingPrescription = prescriptionService.getPrescriptionById(id);
        mav.addObject("existingPrescription", existingPrescription);
        return mav;
    }

    @GetMapping("/prescriptionByName/{patientName}")
    public Prescription findPrescriptionByPatientName(@PathVariable String patientName) {
        return prescriptionService.getPrescriptionByPatientName(patientName);
    }

    @RequestMapping("/delete/{id}")
    public String deletePrescription(@PathVariable(name= "id") int id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/";
    }
}
