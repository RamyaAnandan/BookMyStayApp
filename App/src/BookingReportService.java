import java.util.List;

/**
 * Use Case 8: Booking Report Service
 *
 * Description:
 * Generates reports from booking history.
 *
 * Reporting logic is separate from data storage.
 *
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Generate and display report
     */
    public void generateReport(BookingHistory history) {

        System.out.println("\nBooking History Report");

        List<Reservation> reservations =
                history.getConfirmedReservations();

        for (Reservation r : reservations) {
            System.out.println("Guest: "
                    + r.getGuestName()
                    + ", Room Type: "
                    + r.getRoomType());
        }
    }
}
