import java.util.*;

/**
 * CLASS - AddOnServiceManager
 *
 * Description:
 * Manages optional services associated with reservations.
 *
 * Supports multiple services per reservation.
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    // Map: reservationId -> list of services
    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Add service to a reservation
     */
    public void addService(String reservationId, Service service) {
        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculate total add-on cost
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<Service> services = servicesByReservation.get(reservationId);

        if (services == null) return 0;

        double total = 0;
        for (Service s : services) {
            total += s.getCost();
        }

        return total;
    }}
