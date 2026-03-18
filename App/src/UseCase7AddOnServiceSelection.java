/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Demonstrates attaching optional services
 * to a confirmed booking.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Add-On Service Selection");
        System.out.println("=================================");

        // Assume reservation from UC6
        String reservationId = "Single-1";

        // Create services
        Service breakfast = new Service("Breakfast", 500);
        Service spa = new Service("Spa", 1000);

        // Service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Attach services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Calculate total cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output (matches page 7)
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
