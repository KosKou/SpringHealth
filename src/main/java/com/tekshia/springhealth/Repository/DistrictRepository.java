package com.tekshia.springhealth.Repository;

import com.tekshia.springhealth.Entity.District;
import com.tekshia.springhealth.Entity.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {

    Collection<District> findAllByNation_Id(long id);
}
