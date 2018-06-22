package com.tekshia.springhealth.Services;

import com.tekshia.springhealth.Entity.Drug;
import com.tekshia.springhealth.Repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;
    //    Drugs Finding
    public Collection<Drug> findAll(){
        List<Drug> Drugs = new ArrayList<Drug>();
        for (Drug Drug: drugRepository.findAll()          ) {
            Drugs.add(Drug);
        }
        return Drugs;
    }
    //Find By Id
    public Drug findById(long id){
        return drugRepository.findById(id).get();
    }
    //Add Drug
    public void save(Drug Drug){
        drugRepository.save(Drug);
    }
    //Update Drug
    public void update(Drug Drug){
        drugRepository.save(Drug);
    }
    //Delete Drug
    public void delete(long id){
        drugRepository.deleteById(id);
    }

}
