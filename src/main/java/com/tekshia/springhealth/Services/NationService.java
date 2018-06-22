package com.tekshia.springhealth.Services;

import com.tekshia.springhealth.Entity.Nation;
import com.tekshia.springhealth.Repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class NationService {
    @Autowired
    private NationRepository nationRepository;

    //    Patiens Finding
    public Collection<Nation> findAll(){
        List<Nation> nations = new ArrayList<Nation>();
        for (Nation nation: nationRepository.findAll()          ) {
            nations.add(nation);
        }
        return nations;
    }
    //Find By Id
    public Nation findById(long id){
        return nationRepository.findById(id).get();
    }
    //Add nation
    public void save(Nation nation){
        nationRepository.save(nation);
    }
    //Update nation
    public void update(Nation nation){
        nationRepository.save(nation);
    }
    //Delete nation
    public void delete(long id){
        nationRepository.deleteById(id);
    }
}
