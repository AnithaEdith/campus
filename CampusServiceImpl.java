package com.jstudyplanner.service.implementation;

import com.jstudyplanner.dao.CampusDAO;
import com.jstudyplanner.domain.Campus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 
 * @author oleg, oleglukin@yahoo.com
 */
//@Component("campusService")

@Controller
@RequestMapping("/campusService")
public class CampusServiceImpl {

    Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	CampusDAO campusDAO;

	@RequestMapping(value = "/getAllCampuses", method = RequestMethod.GET)
	public @ResponseBody List<Campus> getAllCampuses() {
        List<Campus> allCampuses = campusDAO.getAllCampuses();
        logger.info("count is " + allCampuses.size() );
        return allCampuses;
	}

	@RequestMapping(value = "/getCampusesByStatus", method = RequestMethod.GET)
	public  @ResponseBody List<Campus> getCampusesByStatus(boolean enabled) {
		return campusDAO.getCampusesByStatus(enabled);
	}

	public void save(Campus campus) {
		// TODO add localization to exception error message
		// TODO add error codes
		Campus campusToCheck = campusDAO.getCampusByCode(campus.getCode());
		if (GeneralService.domainObjectsAreSame(campus, campusToCheck)) {
			throw new CustomServiceException("","There is already a campus with code '" + campus.getCode() + "'. Campus code should be unique.");
		}
		
		campusToCheck = campusDAO.getCampusByTitle(campus.getTitle());
		if (GeneralService.domainObjectsAreSame(campus, campusToCheck)) {
			throw new CustomServiceException("","There is already a campus named '" + campus.getTitle() + "'. Campus title should be unique.");
		}
		
		if ( campus.getId() == null ) {
			campusDAO.add(campus);
		} else {
			campusDAO.save(campus);
		}
	}

	@RequestMapping("/deleteCampuses")
	public void delete(Campus campus) {
		// TODO throw exception if not found or unsuccessful. CustomServiceException
		// TODO check all business constraints for campus delete (e.g. course availability, students enrolled)
		campusDAO.delete(campus);
	}

	@RequestMapping("/getCampusById")
	public Campus getCampusById(Long id) {
		return campusDAO.getCampusById(id);
	}

	@RequestMapping("/getCampusByCode")
	public Campus getCampusByCode(String code) {
		return campusDAO.getCampusByCode(code);
	}
}