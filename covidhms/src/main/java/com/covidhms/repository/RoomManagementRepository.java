package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covidhms.model.RoomManagement;

public interface RoomManagementRepository extends JpaRepository<RoomManagement, Integer>{

	@Query("FROM RoomManagement where patientId = :id")
	public List<RoomManagement> findAllById(@Param("id")int id);
}
