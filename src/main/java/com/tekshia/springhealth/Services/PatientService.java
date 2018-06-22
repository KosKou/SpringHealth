package com.tekshia.springhealth.Services;

import com.tekshia.springhealth.Entity.Patient;
import com.tekshia.springhealth.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    //    Patiens Finding
    public Collection<Patient> findAll(){
        List<Patient> patients = new ArrayList<Patient>();
        for (Patient patient: patientRepository.findAll()          ) {
            patients.add(patient);
        }
        return patients;
    }
    //Find By Id
    public Patient findById(long id){
        return patientRepository.findById(id).get();
    }
    //Add Patient
    public void save(Patient patient){
        patientRepository.save(patient);
    }
    //Update Patient
    public void update(Patient patient){
        patientRepository.save(patient);
    }
    //Delete Patient
    public void delete(long id){
        patientRepository.deleteById(id);
    }
}
