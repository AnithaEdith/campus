package com.jstudyplanner.service.implementation;

import com.jstudyplanner.repository.CampusDao;
import com.jstudyplanner.domain.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusServiceImplementation implements CampusService {
    @Autowired
    private CampusDao campusRepo;

   /* @Autowired
    public CampusServiceImplementation(CampusRepo campusRepo) {
        this.campusRepo = campusRepo;
    }
*/
    @Override
    public void save(Campus campus) {
        campusRepo.save(campus);
    }

    @Override
    public void delete(Campus campus) {
        campusRepo.delete(campus);
    }

    @Override
    public Campus getCampusById(Long id) {
        return campusRepo.findOne(id);
    }

    @Override
    public Campus getCampusByCode(String code) {
        return campusRepo.findCampusByCode(code);
    //    return null;
    }

    @Override
    public Iterable<Campus> getAllCampuses() {
        return campusRepo.findAll();
    }

    @Override
    public Iterable<Campus> getCampusesByStatus(boolean enabled) {
      //  return campusRepo.getCampusesByStatus(enabled);
        return null;
    }
}
