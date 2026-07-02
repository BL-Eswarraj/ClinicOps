import java.util.ArrayList;
import java.util.Scanner;

public class FrontDeskMenu {
    private static final int PATIENT_REGISTRATION = 1;
    private static final int BOOK_APPOINTMENT = 2;
    private static final int VIEW_PATIENTS = 3;
    private static final int LOGOUT = 4;

    //Add Patient in Array
    private static ArrayList<Patient> patients = new ArrayList<>();

    private static int patientIdCounter = 1;

    public static void showMenu(Scanner scanner){

        boolean logout = false;

        while(!logout){
            System.out.println("----FRONT DESK MENU----");
            System.out.println();
            System.out.println("1. Patient Registration");
            System.out.println("2. Book Appointment");
            System.out.println("3. View Patients");
            System.out.println("4. Logout");
            System.out.print("Enter Your Choice: ");

            int choice = ScannerHelper.readInt(scanner);
            switch(choice){
                case PATIENT_REGISTRATION:
                    registerPatient(scanner);
                    break;

                case BOOK_APPOINTMENT:
                    System.out.println("Initiating Book Appointment Process...");
                    break;
                case VIEW_PATIENTS:
                    viewPatients();
                    break;
                case LOGOUT:
                    System.out.println("Logging Out From FrontDesk Menu....");
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid Choice, Choose the Existing options....");
            }
        }
    }

    private static void registerPatient(Scanner scanner) {

    System.out.println("\n===== PATIENT REGISTRATION =====");

    // Generate Patient ID
    String patientId = String.format("P%04d", patientIdCounter++);

    // Read patient details
    String name = ScannerHelper.readString(scanner, "Enter Patient Name: ");
    String gender = ScannerHelper.readString(scanner, "Enter Gender: ");
    int age = ScannerHelper.readIntwithPrompt(scanner, "Enter Age: ");
    String mobileNumber = ScannerHelper.readMobileNumber(scanner, "Enter Mobile Number: ");

    // Create Patient object
    Patient patient = new Patient(
            patientId,
            name,
            gender,
            age,
            mobileNumber);

    // Store in ArrayList
    patients.add(patient);

    System.out.println("\nPatient Registered Successfully.");
    System.out.println("Generated Patient ID : " + patientId);
   }

   private static void viewPatients() {

    System.out.println("\n===== REGISTERED PATIENTS =====");

    if (patients.isEmpty()) {
        System.out.println("No Patients Registered Yet.");
        return;
    }

    for (Patient patient : patients) {
        System.out.println(patient);
    }
}

}
