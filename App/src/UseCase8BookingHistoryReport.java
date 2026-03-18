/**
 * ============================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Demonstrates storing confirmed bookings
 * and generating reports.
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Booking History and Reporting");
        System.out.println("=================================");

        // Create booking history
        BookingHistory history = new BookingHistory();

        // Add confirmed bookings (from previous use case output)
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        // Generate report
        BookingReportService reportService =
                new BookingReportService();

        reportService.generateReport(history);
    }
}