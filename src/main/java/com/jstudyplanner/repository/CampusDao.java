package com.jstudyplanner.repository;

import com.jstudyplanner.domain.Campus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusDao extends CrudRepository<Campus, Long> {

    Iterable<Campus> findByCode(String code);

   /* Iterable<Campus> getCampusesByStatus(boolean enabled);*/

}
