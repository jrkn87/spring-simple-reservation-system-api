package pl.jrkn87.reservationsystem.domain.guest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jrkn87.reservationsystem.ResponseEntityCustomMessage;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("http://jrkn87.usermd.net")
public class GuestController {
    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping()
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guestById = guestService.findGuestById(id);
        if (guestById == null)
            return ResponseEntity.status(404).body(guestById);
        else
            return ResponseEntity.ok(guestById);
    }

    @PostMapping()
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        guestService.createNewGuest(guest);
        return ResponseEntity.status(201).body(guest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  updateGuestById(@PathVariable Long id, @RequestBody Guest guest) {
        if(guestService.updateGuest(id, guest))
            return ResponseEntity.ok().body(ResponseEntityCustomMessage.UPDATE);
        else
            return ResponseEntity.status(201).body(ResponseEntityCustomMessage.CREATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuestById(@PathVariable Long id) {
        if(guestService.deleteGuestById(id))
            return ResponseEntity.ok().body(ResponseEntityCustomMessage.DELETE);
        else
            return ResponseEntity.status(404).body(ResponseEntityCustomMessage.NOT_DELETE);
    }
}
