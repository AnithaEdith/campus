package com.jstudyplanner.repository;

import com.jstudyplanner.domain.Campus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusDao extends CrudRepository<Campus, Long> {
    Campus findCampusByCode(String code);

   /* Iterable<Campus> getCampusesByStatus(boolean enabled);*/

}
