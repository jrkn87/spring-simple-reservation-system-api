package pl.jrkn87.reservationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.jrkn87.reservationsystem.domain.guest.Guest;
import pl.jrkn87.reservationsystem.domain.guest.GuestService;
import pl.jrkn87.reservationsystem.domain.room.Room;
import pl.jrkn87.reservationsystem.domain.room.RoomService;

@Component
public class InitDB implements CommandLineRunner {
    @Autowired
    GuestService guestService;
    @Autowired
    RoomService roomService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- INIT GUEST DATABASE");
        roomService.createNewRoom(Room.of(21, 4));
        guestService.createNewGuest(new Guest("Janusz", "Woźny", 35));
        System.out.println("--- ALL GUESTS COUNT: " + guestService.getAllGuests().size());
        System.out.println("--- ALL ROOMS COUNT: " + roomService.getAllRooms().size());
    }
}
