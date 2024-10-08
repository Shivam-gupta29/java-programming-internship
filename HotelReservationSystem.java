


class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }
}

class Booking {
    private Room room;
    private String customerName;

    public Booking(Room room, String customerName) {
        this.room = room;
        this.customerName = customerName;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        // Sample rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(201, "Suite"));
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Category: " + room.getCategory());
            }
        }
    }

    public void reserveRoom(int roomNumber, String customerName) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.reserve();
                bookings.add(new Booking(room, customerName));
                System.out.println("Room " + roomNumber + " reserved for " + customerName);
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    public void viewBookings() {
        System.out.println("Current Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Customer: " + booking.getCustomerName() + ", Room Number: " + booking.getRoom().getRoomNumber());
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int choice;

        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Reserve Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter Room Number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Your Name: ");
                    String customerName = scanner.nextLine();
                    hotel.reserveRoom(roomNumber, customerName);
                    break;
                case 3:
                    hotel.viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
