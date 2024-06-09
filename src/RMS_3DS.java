import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class RMS_3DS {
    // Menu using HashMap
    HashMap<Integer, String> menu = new HashMap<>();

    // Reservations using HashMap
    HashMap<Integer, String> reservations = new HashMap<>();

    // Orders using Queue and HashMap
    Queue<Integer> orderQueue = new LinkedList<>();
    HashMap<Integer, String> orders = new HashMap<>();

    // Add a menu item
    void addMenuItem(int id, String item) {
        menu.put(id, item);
    }

    // Add a reservation
    void addReservation(int id, String customerDetails) {
        reservations.put(id, customerDetails);
    }

    // Place an order
    void placeOrder(int orderId, String orderDetails) {
        orderQueue.add(orderId);
        orders.put(orderId, orderDetails);
    }

    // Display the menu
    void displayMenu() {
        System.out.println("Menu:");
        for (Integer id : menu.keySet()) {
            System.out.println("ID: " + id + ", Item: " + menu.get(id));
        }
    }

    // Display reservations
    void displayReservations() {
        System.out.println("Reservations:");
        for (Integer id : reservations.keySet()) {
            System.out.println("Reservation ID: " + id + ", Customer: " + reservations.get(id));
        }
    }

    // Process orders
    void processOrders() {
        System.out.println("Processing Orders:");
        while (!orderQueue.isEmpty()) {
            int orderId = orderQueue.poll();
            System.out.println("Order ID: " + orderId + ", Details: " + orders.get(orderId));
        }
    }

    // Search for a menu item
    void searchMenuItem(int id) {
        if (menu.containsKey(id)) {
            System.out.println("Menu Item Found: ID: " + id + ", Item: " + menu.get(id));
        } else {
            System.out.println("Menu Item Not Found: ID: " + id);
        }
    }

    // Insert a menu item
    void insertMenuItem(int id, String item) {
        menu.put(id, item);
        System.out.println("Inserted Menu Item: ID: " + id + ", Item: " + item);
    }

    // Delete a menu item
    void deleteMenuItem(int id) {
        if (menu.remove(id) != null) {
            System.out.println("Deleted Menu Item: ID: " + id);
        } else {
            System.out.println("Menu Item Not Found: ID: " + id);
        }
    }

    // Search for a reservation
    void searchReservation(int id) {
        if (reservations.containsKey(id)) {
            System.out.println("Reservation Found: ID: " + id + ", Customer: " + reservations.get(id));
        } else {
            System.out.println("Reservation Not Found: ID: " + id);
        }
    }

    // Insert a reservation
    void insertReservation(int id, String customerDetails) {
        reservations.put(id, customerDetails);
        System.out.println("Inserted Reservation: ID: " + id + ", Customer: " + customerDetails);
    }

    // Delete a reservation
    void deleteReservation(int id) {
        if (reservations.remove(id) != null) {
            System.out.println("Deleted Reservation: ID: " + id);
        } else {
            System.out.println("Reservation Not Found: ID: " + id);
        }
    }

    // Search for an order
    void searchOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            System.out.println("Order Found: ID: " + orderId + ", Details: " + orders.get(orderId));
        } else {
            System.out.println("Order Not Found: ID: " + orderId);
        }
    }

    // Insert an order
    void insertOrder(int orderId, String orderDetails) {
        orderQueue.add(orderId);
        orders.put(orderId, orderDetails);
        System.out.println("Inserted Order: ID: " + orderId + ", Details: " + orderDetails);
    }

    // Delete an order
    void deleteOrder(int orderId) {
        if (orders.remove(orderId) != null) {
            orderQueue.remove(orderId);
            System.out.println("Deleted Order: ID: " + orderId);
        } else {
            System.out.println("Order Not Found: ID: " + orderId);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        RMS_3DS rms = new RMS_3DS();

        // Adding items
        long addingStartTime = System.nanoTime();
        for (int i = 0; i < 25; i++) {
            rms.addMenuItem(i, "Item " + i);
            rms.addReservation(i, "Customer " + i);
            rms.placeOrder(i, "Order " + i);
        }
        long addingEndTime = System.nanoTime();

        // Deleting an item
        long deletingStartTime = System.nanoTime();
        rms.deleteMenuItem(5);
        rms.deleteReservation(5);
        rms.deleteOrder(5);
        long deletingEndTime = System.nanoTime();

        // Inserting an item
        long insertingStartTime = System.nanoTime();
        rms.insertMenuItem(5, "Magic Item");
        rms.insertReservation(5, "Magic Customer");
        rms.insertOrder(5, "Magic Order");
        long insertingEndTime = System.nanoTime();

        // Displaying menu, reservations, and processing orders
        long displayingStartTime = System.nanoTime();
        rms.displayMenu();
        rms.displayReservations();
        rms.processOrders();
        long displayingEndTime = System.nanoTime();

        // Searching for items
        long searchingStartTime = System.nanoTime();
        rms.searchMenuItem(5);
        rms.searchReservation(5);
        rms.searchOrder(5);
        long searchingEndTime = System.nanoTime();

        long endTime = System.nanoTime(); // Time after searching

        // Calculate memory usage
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem; // Calculate the memory being used

        // Print time and memory usage
        System.out.println("\nTime taken to add to the system: " + (addingEndTime - addingStartTime) + " ns");
        System.out.println("Time taken to delete from the system: " + (deletingEndTime - deletingStartTime) + " ns");
        System.out.println("Time taken to insert into the system: " + (insertingEndTime - insertingStartTime) + " ns");
        System.out.println("Time taken to print the system: " + (displayingEndTime - displayingStartTime) + " ns");
        System.out.println("Time taken to search the system: " + (searchingEndTime - searchingStartTime) + " ns");
        System.out.println("Total runtime: " + (endTime - startTime) + " ns");
        System.out.println("Amount of used memory: " + usedMem / (1024.0 * 1024.0) + " MB");
    }
}
