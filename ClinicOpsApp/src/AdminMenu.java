import java.util.Scanner;
import java.util.ArrayList;

public class AdminMenu {

    private static final int DOC_ENTRY = 1;
    private static final int BULK_DATA_ENTRY = 2;
    private static final int VIEW_AUDIT_LOGS = 3;
    private static final int DISPLAY_DOCTORS = 4;
    private static final int LOGOUT = 5;

    //Storing Doctor detials
    private static ArrayList<Doctor> doctors = new ArrayList<>(); 

    // Used to generate unique Doctor IDs
    private static int idCounter = 1;

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
                bulkDataEntry(scanner);
                break;
            case VIEW_AUDIT_LOGS:
                AuditLogger.displayLogs();
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
        
        System.out.println("------ CLINIC ADMIN MENU ------");
        System.out.println();
        System.out.println("1. Doctor Data Entry");
        System.out.println("2. Bulk Data Entry");
        System.out.println("3. View Audit Logs");
        System.out.println("4. Display Doctor's Data");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }

    private static void registerDoctors(Scanner scanner){

        //Store docotors in Array
        for (int i =0; i<3; i++){

            System.out.println("\n====REGISTER DOCTOR "+ (i+1) +"====");

            String name = ScannerHelper.readString(scanner, "Enter Doctor Name: ");
            Specialization specialization = ScannerHelper.readEnumchoice(scanner, "Enter Speciliztion",Specialization.values());
            int experience = ScannerHelper.readIntwithPrompt(scanner, "Enter Doctor Experience: ");
            Shift shift = ScannerHelper.readEnumchoice(scanner, "Enter Shift: ", Shift.values());

            String id = String.format("D%04d", idCounter);

            idCounter++;

            //Create Doctor Object
            Doctor doctor = new Doctor(id, name, specialization, experience,shift);
            // Adding to array
            doctors.add(doctor);

            AuditLogger.log("Doctor Registered:"+ id+" - "+ name,"INFO");
        }
        System.out.println("\nDoctors registered successfully.");
    }
    //Display Doctors
    private static void displayDoctors() {
        System.out.println("\n====REGISTERED DOCTORS=====");
        System.out.println();

        if (doctors.isEmpty()){
            System.out.println("No Doctors Registered yet");
            return;
        }

        for(Doctor doctor: doctors){
            System.out.println(doctor);
        }
    }

    private static void bulkDataEntry(Scanner scanner) {

    String filePath = ScannerHelper.readString(
            scanner,
            "Enter CSV file path: ");

    ArrayList<Doctor> importedDoctors =
            FileHandler.readDoctorsFromCSV(filePath, idCounter);

    doctors.addAll(importedDoctors);

    idCounter += importedDoctors.size();

    System.out.println();

    System.out.println(importedDoctors.size()
            + " Doctors imported successfully.");
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

}

