package com.covidhms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.model.RoomManagement;
import com.covidhms.model.Rooms;
import com.covidhms.repository.RoomManagementRepository;
import com.covidhms.repository.RoomRepository;


@Service
public class RoomService {

	
	@Autowired
	private RoomRepository repo;
	
	@Autowired
	private RoomManagementRepository rmrepo;
	
	
	
	public void addNewRoom(Rooms r) {
		repo.save(r);
	}
	
	public void addNewBed(RoomManagement rm) {
		int id = rm.getRoomNo();
		Rooms r = repo.getOne(id);
		r.setStatus("Occupied");
		repo.save(r);
		rmrepo.save(rm);
	}
	
	
	public List<Rooms> getRoomInfo(){
		return repo.findAll();
	}
	
	public List<RoomManagement> getRoomStatusInfo(){
		return rmrepo.findAll();
	}
	
	public List<Rooms> getRoomNumbers(String type){
		return repo.findAllByType(type);
	}
	
	public void deleteRoomById(int id) throws Exception {
		
		Rooms entity = repo.getOne(id);
		repo.delete(entity);
	}
	
	public List<RoomManagement> getAllRoomsOfPatientId(int patientId) {
		// TODO Auto-generated method stub
		return rmrepo.findAllById(patientId);
	}
}
