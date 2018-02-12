package com.jstudyplanner.controllers;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.service.implementation.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private CampusService campusService;

/*
    @Autowired
    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }
*/

    @RequestMapping(value = "/getAllCampuses", method = RequestMethod.GET)
    public @ResponseBody
    List<Campus> getAllCampuses() {
        List<Campus> campuses=new ArrayList<Campus>();
        Iterable<Campus> allCampuses = campusService.getAllCampuses();
        campuses= collectlist(allCampuses);
        return campuses;
    }

    @RequestMapping(value = "/getCampusesByStatus", method = RequestMethod.GET)
    public  @ResponseBody List<Campus> getCampusesByStatus(boolean enabled) {
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

    @RequestMapping("/getCampusById")
    public Campus getCampusById(Long id) {

        return campusService.getCampusById(id);
    }

    @RequestMapping("/getCampusByCode")
    public Campus getCampusByCode(String code) {
        return campusService.getCampusByCode(code);
    }


    private List<Campus> collectlist(Iterable<Campus> allCampuses) {
        return StreamSupport.stream(allCampuses.spliterator(), false).collect(Collectors.toList());
    }


}
