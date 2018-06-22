package com.tekshia.springhealth.Repository;

import com.tekshia.springhealth.Entity.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Long> {
}
