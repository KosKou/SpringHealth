package com.tekshia.springhealth.Controller;

import com.tekshia.springhealth.Entity.District;
import com.tekshia.springhealth.Services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @GetMapping("/getDistricts")
    public Collection<District> getDistricts(Model model, @RequestParam long id){
        model.addAttribute("districts", districtService.findAllByNation(id));
        return districtService.findAllByNation(id);
    }
}
