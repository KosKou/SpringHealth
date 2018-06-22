package com.tekshia.springhealth.Controller;

import com.tekshia.springhealth.Entity.Drug;
import com.tekshia.springhealth.Services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrugController {
    @Autowired
    DrugService drugService;

//    List of Drugs
    @GetMapping("/drug")
    public String init(Model model){
        model.addAttribute("drugs", drugService.findAll());
        model.addAttribute("mode", "DRUG_VIEW");
        return "drug";
    }

//    Save Drug
    @PostMapping("/saveDrug")
    public String saveDrug(Model model, @ModelAttribute Drug drug){
        drugService.save(drug);
        model.addAttribute("drugs", drugService.findAll());
        model.addAttribute("mode", "DRUG_VIEW");
        return "redirect:/drug";
    }
//    Delete Drug
    @DeleteMapping("/deleteDrug")
    public String deleteDrug(Model model, @RequestParam long id){
        drugService.delete(id);
        model.addAttribute("drugs", drugService.findAll());
        model.addAttribute("mode", "DRUG_VIEW");
        return "redirect:/drug";
    }
//    Update Drug
    @PutMapping("/updateDrug")
    public String updateDrug(Model model, @RequestParam long id){
        model.addAttribute("drug", drugService.findById(id));
        model.addAttribute("mode","DRUG_VIEW");
        return "drug";
    }
    /*
     * Template Usage Redirect
     * */
    @GetMapping("/newDrug")
    public String addDrug(Model model){
        model.addAttribute("drug", new Drug());
        model.addAttribute("mode", "DRUG_EDIT");
        return "drug";
    }


}
