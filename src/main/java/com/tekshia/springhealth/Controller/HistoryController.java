package com.tekshia.springhealth.Controller;

import com.tekshia.springhealth.Entity.History;
import com.tekshia.springhealth.Entity.Patient;
import com.tekshia.springhealth.Services.HistoryService;
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
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/checkHistory")
    public String init(Model model, @RequestParam long id){
        model.addAttribute("patient_id",id);
        model.addAttribute("histories", historyService.findAllByPatient(id));
        model.addAttribute("mode", "HISTORY_VIEW");
        return "history";
    }

    @GetMapping("/newHistory")
    public String addHistory(Model model, @RequestParam long id) {
        History history = new History();
        history.setPatient(patientService.findById(id));
        model.addAttribute("history", history);
        model.addAttribute("mode", "HISTORY_EDIT");
        model.addAttribute("patient_id",id);
        model.addAttribute("histories", historyService.findAllByPatient(id));
        return "history";
    }

    //    Save Patient
    @PostMapping("/saveHistory")
    public String save(@ModelAttribute History history, BindingResult bindingResult, Model model) {
        history.setPatient(patientService.findById(history.getPatient().getId()));
        historyService.save(history);
        model.addAttribute("patient_id",history.getPatient().getId());
        model.addAttribute("histories", historyService.findAllByPatient(history.getPatient().getId()));
        model.addAttribute("mode", "HISTORY_VIEW");
        return "history";
    }

    //Date Type Config to fix issues
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
