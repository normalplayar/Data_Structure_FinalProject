import java.util.ArrayList;

class RMS_Arl {
    // Menu using arrays
    ArrayList<String> menuItems = new ArrayList<>();

    // Reservations using arrays
    ArrayList<String>  reservations = new ArrayList<>();

    // Orders using arrays
    ArrayList<String>  orders = new ArrayList<>();

    // Display the menu
    void displayMenu() {
        System.out.println("Menu:");
        for (String menuItem : menuItems) {
            System.out.println("Item: " + menuItem);
        }
    }

    // Display reservations
    void displayReservations() {
        System.out.println("Reservations:");
        for (String reservation : reservations) {
            System.out.println("Customer: " + reservation);
        }
    }

    // Process orders
    void processOrders() {
        System.out.println("Processing Orders:");
        for (String order : orders) {
            System.out.println("Order Details: " + order);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        RMS_Arl brms = new RMS_Arl();

        for (int i = 0;i < 10; i++){
            // Adding menu items
            brms.menuItems.add("Item: " + i);

            // Adding reservations
            brms.reservations.add("Name: " + i);

            // Placing orders
            brms.orders.add("Food: " + i);
        }

        long addingTime = System.nanoTime(); // Time after adding the system

        brms.menuItems.add(5, "magic");
        brms.reservations.add(5,"magic");
        brms.orders.add(5,"magic");

        long insertingTime = System.nanoTime(); // Time after inserting into the system;

        brms.menuItems.remove(6);
        brms.reservations.remove(6);
        brms.orders.remove(6);

        long removeTime = System.nanoTime(); // Time after removing element from system

        // Displaying menu, reservations, and processing orders
        brms.displayMenu();
        brms.displayReservations();
        brms.processOrders();

        long printingTime = System.nanoTime(); // Time after printing

        if (brms.menuItems.contains("magic")){
            System.out.println("Exist at " + brms.menuItems.indexOf("magic"));
        } else {
            System.out.println("Does not exist");
        }
        if (brms.reservations.contains("magic")){
            System.out.println("Exist at " + brms.reservations.indexOf("magic"));
        } else {
            System.out.println("Does not exist");
        }
        if (brms.orders.contains("magic")){
            System.out.println("Exist at " + brms.orders.indexOf("magic"));
        } else {
            System.out.println("Does not exist");
        }

        long endTime = System.nanoTime(); // Time for program

        // Calculate memory usage
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem; // Calculate the memory being used

        // Print time and memory usage
        System.out.println("\nTime taken to add the system: " + (addingTime - startTime) + " ns");
        System.out.println("Time taken to insert the orders: " + (insertingTime - addingTime) + " ns");
        System.out.println("Time taken to remove element: " + (removeTime - insertingTime) + " ns");
        System.out.println("Time taken to print the orders: " + (printingTime - removeTime) + " ns");
        System.out.println("Time taken to search the orders: " + (endTime - printingTime) + " ns");
        System.out.println("Total runtime: " + (endTime - startTime) + " ns");
        System.out.println("Amount of used memory: " + usedMem / (1024.0 * 1024.0) + " MB");
    }
}
