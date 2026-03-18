import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Demonstrates validation before booking.
 *
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Booking Validation");
        System.out.println("=================================");

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Get input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(guestName, roomType, inventory);

            // If valid → add to queue
            bookingQueue.addRequest(new Reservation(guestName, roomType));

            System.out.println("Booking request accepted.");

        } catch (InvalidBookingException e) {

            // Handle validation errors (page 7)
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}}
