import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * Confirms booking requests and assigns rooms.
 *
 * Ensures:
 * - Unique room IDs
 * - No double booking
 * - Inventory updated immediately
 *
 * @version 6.0
 */
public class RoomAllocationService {

    // Stores all allocated room IDs (global uniqueness)
    private Set<String> allocatedRoomIds;

    // Maps room type -> allocated room IDs
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Constructor
     */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates room and confirms booking
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        // Check availability
        int available = inventory.getRoomAvailability().get(roomType);

        if (available <= 0) {
            System.out.println("No rooms available for " + roomType +
                    " (Guest: " + reservation.getGuestName() + ")");
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store allocation
        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (decrement)
        inventory.updateAvailability(roomType, available - 1);

        // Confirmation output (matches page 6)
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: "
                + roomId);
    }

    /**
     * Generates unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType + "-" + count;

        // Ensure uniqueness (extra safety)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}
