package com.tekshia.springhealth.Controller;

import com.tekshia.springhealth.Services.DistrictService;
import com.tekshia.springhealth.Services.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {
//    Instanciamos clase de Servicios Nation y Distrito
    @Autowired
    private NationService nationService;
    @Autowired
    private DistrictService districtService;
//    Cuando el usuario va al url /location
    @GetMapping("/location")
    public String init(Model model){
        model.addAttribute("nations", nationService.findAll());
//        model.addAttribute("districts", districtService.findAll());
        return "location";
    }
    //Ajax incorporado para listar distritos
    @GetMapping("/ajax/districts")
    public String ajaxDistrict(@RequestParam("nationality") long id, Model model){
        model.addAttribute("districts", districtService.findAllByNation(id));
        return "location :: districts";
    }
}
