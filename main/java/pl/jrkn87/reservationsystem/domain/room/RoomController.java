package pl.jrkn87.reservationsystem.domain.room;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jrkn87.reservationsystem.ResponseEntityCustomMessage;
import pl.jrkn87.reservationsystem.domain.guest.Guest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin("http://jrkn87.usermd.net")
//@CrossOrigin("http://localhost:3000")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllGuests() {
        return this.roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return this.roomService.findRoomById(id);
    }

    @PostMapping
    public void createNewRoom(@RequestBody Room room) {
        this.roomService.createNewRoom(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuestById(@PathVariable Long id, @RequestBody Room room) {
        if(roomService.updateRoom(id, room))
            return ResponseEntity.ok().body(ResponseEntityCustomMessage.UPDATE);
        else
            return ResponseEntity.status(201).body(ResponseEntityCustomMessage.CREATE);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        this.roomService.deleteRoom(id);
    }
}
