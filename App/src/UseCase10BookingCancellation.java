/**
 * ============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * @developer RamyaAnandan
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Booking Cancellation");
        System.out.println("=================================");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Cancellation service
        CancellationService service = new CancellationService();

        // Simulate confirmed booking (from UC6)
        String reservationId = "Single-1";
        service.registerBooking(reservationId, "Single");

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}
