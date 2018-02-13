package com.jstudyplanner.service.implementation;

import com.jstudyplanner.repository.CampusDao;
import com.jstudyplanner.domain.Campus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServiceImplementation implements CampusService {
    Logger logger= LoggerFactory.getLogger(this.getClass());

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
    public Iterable<Campus> getCampusByCode(String code) {
        logger.info(" inside Campus Service" + code);
        Iterable<Campus> campusList=campusRepo.findByCode(code);
        return campusList;
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
