import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 8: Booking History
 *
 * Description:
 * Maintains a record of confirmed reservations.
 *
 * Provides ordered storage for audit and reporting.
 *
 * @version 8.0
 */
public class BookingHistory {

    // List storing confirmed reservations
    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /**
     * Add confirmed reservation
     */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /**
     * Get all reservations
     */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}
