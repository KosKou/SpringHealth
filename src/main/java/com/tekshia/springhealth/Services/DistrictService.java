package com.tekshia.springhealth.Services;

import com.tekshia.springhealth.Entity.District;
import com.tekshia.springhealth.Entity.Nation;
import com.tekshia.springhealth.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    //    Distric Finding
    public Collection<District> findAll(){
        List<District> districts = new ArrayList<District>();
        for (District district: districtRepository.findAll()          ) {
            districts.add(district);
        }
        return districts;
    }
//    By Nation
    public Collection<District> findAllByNation(long id){
        List<District> districts = new ArrayList<District>();
        for (District district: districtRepository.findAllByNation_Id(id)          ) {
            districts.add(district);
        }
        return districts;
    }
    //Find By Id
    public District findById(long id){
        return districtRepository.findById(id).get();
    }
    //Add district
    public void save(District district){
        districtRepository.save(district);
    }
    //Update district
    public void update(District district){
        districtRepository.save(district);
    }
    //Delete district
    public void delete(long id){
        districtRepository.deleteById(id);
    }
}
