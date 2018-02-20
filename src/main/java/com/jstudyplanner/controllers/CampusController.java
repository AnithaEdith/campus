package com.jstudyplanner.controllers;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.service.implementation.CampusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/campusService")
public class CampusController {

    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CampusService campusService;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public @ResponseBody
    List<Campus> healthcheck() {
        List<Campus> campuses=new ArrayList<Campus>();
        Iterable<Campus> allCampuses = campusService.getAllCampuses();
        campuses= collectlist(allCampuses);
        return campuses;
    }

    @RequestMapping(value = "/getAllCampuses", method = RequestMethod.GET)
    public @ResponseBody
    List<Campus> getAllCampuses() {
        List<Campus> campuses=new ArrayList<Campus>();
        Iterable<Campus> allCampuses = campusService.getAllCampuses();
        campuses= collectlist(allCampuses);
        return campuses;
    }

    @RequestMapping(value = "/getCampusesByStatus/enabled/{enabledflag}", method = RequestMethod.GET)
    public  @ResponseBody List<Campus> getCampusesByStatus( @PathVariable boolean enabled) {
        List<Campus> campuses=new ArrayList<Campus>();
        Iterable<Campus> allCampuses = campusService.getCampusesByStatus(enabled);
        campuses= collectlist(allCampuses);
        return campuses;
    }

    @RequestMapping(value = "/saveCampus", method = RequestMethod.POST)
    public void save(Campus campus) {
        campusService.save(campus);

    }

    @RequestMapping("/deleteCampuses")
    public void delete(Campus campus) {
        campusService.delete(campus);
    }

    @RequestMapping("/getCampusById/{id}")
    public Campus getCampusById(@PathVariable Long id) {

        return campusService.getCampusById(id);
    }

    @RequestMapping(value="/getCampusByCode/{code}", method = RequestMethod.GET)
    public  @ResponseBody Campus getCampusByCode(@PathVariable String code) {
        List<Campus> campuses=new ArrayList<Campus>();

        logger.info("inside getCampusByCode" + code);
        Iterable<Campus> allCampuses = campusService.getCampusByCode(code);
        campuses= collectlist(allCampuses);
        logger.info("after  getCampusByCode" + campuses.size());

        return campuses.get(0);
    }


    private List<Campus> collectlist(Iterable<Campus> allCampuses) {
        return StreamSupport.stream(allCampuses.spliterator(), false).collect(Collectors.toList());
    }


}
