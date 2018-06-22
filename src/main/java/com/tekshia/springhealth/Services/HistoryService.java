package com.tekshia.springhealth.Services;

import com.tekshia.springhealth.Entity.History;
import com.tekshia.springhealth.Repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    //    Patiens Finding
    public Collection<History> findAll(){
        List<History> histories = new ArrayList<History>();
        for (History history : historyRepository.findAll()) {
            histories.add(history);
        }
        return histories;
    }
    //List by Patient
    public Collection<History> findAllByPatient(long id){
        List<History> histories = new ArrayList<History>();
        for (History history : historyRepository.findAllByPatient_Id(id)){
            histories.add(history);
        }
        return histories;
    }
    //Find By Id
    public History findById(long id){
        return historyRepository.findById(id).get();
    }
    //Add History
    public void save(History patient){
        historyRepository.save(patient);
    }
    //Update History
    public void update(History patient){
        historyRepository.save(patient);
    }
    //Delete History
    public void delete(long id){
        historyRepository.deleteById(id);
    }
}
