package pl.jrkn87.reservationsystem.domain.guest;

import java.util.List;

public interface GuestRepository {
    void create(Guest guest);

    void update(Guest guest);

    Guest findById(long id);

    List<Guest> getAll();

    void delete(Guest guest);
}
