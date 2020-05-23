package play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import play.model.Room;
import play.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository RoomRepository;
	
	public Room getRoomByName(String name) {
		return RoomRepository.findByName(name);
	}
	
	public List<Room> getAll() {
		return RoomRepository.findAll();
	}
	
	public long getNumber() {
		return RoomRepository.count();
	}
	
	public void addRoom(Room room) {
		RoomRepository.save(room);
	}
	
	public void updateCard(Room room) {
		RoomRepository.save(room);
	}
	
	public void deleteRoom(String id) {
		RoomRepository.delete(RoomRepository.findById(Integer.parseInt(id)));
	}
	
	public Room getRoomById(String id) {
		return RoomRepository.findById(Integer.parseInt(id));
	}
}
