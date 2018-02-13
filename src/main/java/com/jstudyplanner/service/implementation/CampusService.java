package com.jstudyplanner.service.implementation;

import com.jstudyplanner.domain.Campus;

import java.util.List;

/**
 * Defines business rules for managing campuses
 */
public interface CampusService {
	public void save(Campus campus);
	public void delete(Campus campus);
	public Campus getCampusById(Long id);
	public Iterable<Campus> getCampusByCode(String code);
	public Iterable<Campus> getAllCampuses();
	public Iterable<Campus> getCampusesByStatus(boolean enabled);
}