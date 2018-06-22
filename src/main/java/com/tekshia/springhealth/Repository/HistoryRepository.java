package com.tekshia.springhealth.Repository;

import com.tekshia.springhealth.Entity.History;
import com.tekshia.springhealth.Entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    public Collection<History> findAllByPatient_Id(long id);
}
