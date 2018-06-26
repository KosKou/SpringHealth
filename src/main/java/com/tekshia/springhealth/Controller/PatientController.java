package com.tekshia.springhealth.Controller;

import com.tekshia.springhealth.Entity.Nation;
import com.tekshia.springhealth.Entity.Patient;
import com.tekshia.springhealth.Services.DistrictService;
import com.tekshia.springhealth.Services.NationService;
import com.tekshia.springhealth.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private NationService nationService;
    @Autowired
    private DistrictService districtService;
//    List Patients
    @GetMapping("/patient")
    public String init(Model model){
        model.addAttribute("patients",patientService.findAll());
        model.addAttribute("mode", "PATIENT_VIEW");
        return "patient";
    }
//    Save Patient
    @PostMapping("/savePatient")
    public String save(@ModelAttribute Patient patient, BindingResult bindingResult, Model model) {
        patientService.save(patient);
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("mode", "PATIENT_VIEW");
        return "redirect:/patient";
    }
//    Delete Patient
    @GetMapping("/deletePatient")
    public String deletePatient(Model model, @RequestParam long id) {
        patientService.delete(id);
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("mode", "PATIENT_VIEW");
        return "redirect:/patient";
    }
//    Update Patient
    @GetMapping("/updatePatient")
    public String init(Model model, @RequestParam long id) {
        model.addAttribute("patient", patientService.findById(id));
        model.addAttribute("mode", "PATIENT_EDIT");
        model.addAttribute("nations", nationService.findAll());
        return "patient";
    }
    /*
    * Template Usage Redirect
    * */
    @GetMapping("/newPatient")
    public String addPatient(Model model) {
        Patient patient = new Patient();
        patient.setNationality(new Nation());
        model.addAttribute("patient", patient);
        model.addAttribute("mode", "PATIENT_EDIT");
        model.addAttribute("nations", nationService.findAll());
        return "patient";
    }

    //Date Type Config to fix issues
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    @GetMapping("/ajax/listDistricts")
    public String listDistricts(Model model, @RequestParam("nationality") long id){
        model.addAttribute("districts", districtService.findAllByNation(id));
        return "patient :: districts";
    }
}
