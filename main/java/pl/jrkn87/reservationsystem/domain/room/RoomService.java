package pl.jrkn87.reservationsystem.domain.room;

import org.springframework.stereotype.Service;
import pl.jrkn87.reservationsystem.domain.guest.Guest;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    public Optional<Room> findRoomById(Long id) {
        return this.roomRepository.findById(id);
    }

    public void createNewRoom(Room room) {
        this.roomRepository.save(room);
    }

    public boolean updateRoom(Long id, Room room) {
        Optional<Room> guestById = roomRepository.findById(id);
        if (guestById.isPresent()) {
            room.setId(guestById.get().getId());
            roomRepository.save(room);
            return true;
        } else {
            roomRepository.save(room);
            return false;
        }
    }

    public void deleteRoom(Long id) {
        Optional<Room> roomById = this.roomRepository.findById(id);
        this.roomRepository.delete(roomById.get());
    }
}
