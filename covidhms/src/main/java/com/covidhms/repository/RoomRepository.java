package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.covidhms.model.Rooms;


public interface RoomRepository extends JpaRepository<Rooms, Integer>{

	public List<Rooms> findAll();

	@Query("FROM Rooms where roomType = :type and status = 'Available'")
	public List<Rooms> findAllByType(String type);
}
