package com.tekshia.springhealth.Repository;

import com.tekshia.springhealth.Entity.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends CrudRepository<Nation, Long> {
}
