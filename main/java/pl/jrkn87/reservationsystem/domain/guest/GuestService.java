package pl.jrkn87.reservationsystem.domain.guest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void createNewGuest(Guest guest) {
        guestRepository.create(guest);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.getAll();
    }

    public Guest findGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public boolean updateGuest(Long id, Guest guest) {
        Guest guestById = guestRepository.findById(id);
        if (guestById!=null) {
            guest.setId(guestById.getId());
            guestRepository.update(guest);
            return true;
        } else {
            guestRepository.create(guest);
            return false;
        }
    }

    public boolean deleteGuestById(Long id) {
        Guest byId = guestRepository.findById(id);
        if (byId == null)
            return false;
        else {
            guestRepository.delete(byId);
            return true;
        }

    }
}
