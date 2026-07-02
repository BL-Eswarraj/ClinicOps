import java.util.Scanner;

public class AdminMenu {

    private static final int DOC_ENTRY = 1;
    private static final int BULK_DATA_ENTRY = 2;
    private static final int VIEW_AUDIT_LOGS = 3;
    private static final int DISPLAY_DOCTORS = 4;
    private static final int LOGOUT = 5;

    public static void showMenu(Scanner scanner){
        boolean logout = false;
        while(!logout)
        {
            displayAdminOptions();
        int choice = ScannerHelper.readInt(scanner);
        switch(choice)
        {
            case DOC_ENTRY:
                registerDoctors(scanner);
                break;
            case BULK_DATA_ENTRY:
                System.out.println("Bulk Data Entry.....");
                break;
            case VIEW_AUDIT_LOGS:
                System.out.println("View Logs....");
                break;
            case DISPLAY_DOCTORS:
                displayDoctors();
                break;
            case LOGOUT:
                System.out.println("Logging Out Admin Menu....");
                logout = true;
                break;
            default:
                System.out.println("Invalid Choice....");
                
        }

        }
    
    }
    private static void displayAdminOptions() {
        // TODO Auto-generated method stub
        System.out.println("------ CLINIC ADMIN MENU ------");
        System.out.println();
        System.out.println("1. Doctor Data Entry");
        System.out.println("2. Bulk Data Entry");
        System.out.println("3. View Audit Logs");
        System.out.println("4. Display Doctor's Data");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }
    //Doctor 1 Details
    private static String doctor1Name;
    private static String doctor1Specialization;
    private static int doctor1Experience;
    private static String doctor1Slots;

    //Doctor 2 Details
    private static String doctor2Name;
    private static String doctor2Specialization;
    private static int doctor2Experience;
    private static String doctor2Slots;

    //Doctor 3 Details
    private static String doctor3Name;
    private static String doctor3Specialization;
    private static int doctor3Experience;
    private static String doctor3Slots;

    private static void registerDoctors(Scanner scanner){

        System.out.println("\n===== Register Doctor 1 =====");

        doctor1Name = ScannerHelper.readString(scanner, "Enter Doctor Name: ");
        doctor1Specialization = ScannerHelper.readString(scanner, "Enter Specialization: ");
        doctor1Experience = ScannerHelper.readIntwithPrompt(scanner, "Enter Experience: ");
        doctor1Slots = ScannerHelper.readString(scanner, "Enter Available Slot: ");

        System.out.println("\n===== Register Doctor 2 =====");

        doctor2Name = ScannerHelper.readString(scanner, "Enter Doctor Name: ");
        doctor2Specialization = ScannerHelper.readString(scanner, "Enter Specialization: ");
        doctor2Experience = ScannerHelper.readIntwithPrompt(scanner, "Enter Experience: ");
        doctor2Slots = ScannerHelper.readString(scanner, "Enter Available Slot: ");

        System.out.println("\n===== Register Doctor 3 =====");

        doctor3Name = ScannerHelper.readString(scanner, "Enter Doctor Name: ");
        doctor3Specialization = ScannerHelper.readString(scanner, "Enter Specialization: ");
        doctor3Experience = ScannerHelper.readIntwithPrompt(scanner, "Enter Experience: ");
        doctor3Slots = ScannerHelper.readString(scanner, "Enter Available Slot: ");

        System.out.println("\nAll three doctors have been registered successfully.");
    }
    //Display Doctors
    private static void displayDoctors() {

    System.out.println("\n------ Registered Doctors ------");

    System.out.println("Doctor 1");
    System.out.println("Name : " + doctor1Name);
    System.out.println("Specialization : " + doctor1Specialization);
    System.out.println("Experience : " + doctor1Experience);
    System.out.println("Slots : " + doctor1Slots);

    System.out.println();

    System.out.println("Doctor 2");
    System.out.println("Name : " + doctor2Name);
    System.out.println("Specialization : " + doctor2Specialization);
    System.out.println("Experience : " + doctor2Experience);
    System.out.println("Slots : " + doctor2Slots);

    System.out.println();

    System.out.println("Doctor 3");
    System.out.println("Name : " + doctor3Name);
    System.out.println("Specialization : " + doctor3Specialization);
    System.out.println("Experience : " + doctor3Experience);
    System.out.println("Slots : " + doctor3Slots);
}
}

