import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FrontDeskMenu {
    private static final int PATIENT_REGISTRATION = 1;
    private static final int BOOK_APPOINTMENT = 2;
    private static final int VIEW_PATIENTS = 3;
    private static final int LOGOUT = 4;
    

    //Add Patient in Array
    private static ArrayList<Patient> patients = new ArrayList<>();

    private static int patientIdCounter = 1;

    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    private static int appointmentCounter = 1;

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
                    bookAppointment(scanner);
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

    String mobileNumber = ScannerHelper.readMobileNumber(scanner, "Enter Mobile Number: ");

    Patient existingPatient  = findPatientByMobile(mobileNumber);
    if (existingPatient != null) {

        System.out.println();
        System.out.println("Patient already registered.");
        System.out.println("Welcome back!");
        System.out.println(existingPatient);

        return;
    }
    // Generate Patient ID
    String patientId = String.format("P%04d", patientIdCounter++);

    // Read patient details
    String name = ScannerHelper.readString(scanner, "Enter Patient Name: ");
    String gender = ScannerHelper.readString(scanner, "Enter Gender: ");
    int age = ScannerHelper.readIntwithPrompt(scanner, "Enter Age: ");
    

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
   private static Patient findPatientByMobile(String mobileNumber) {

    for (Patient patient : patients) {

        if (patient.getMobileNumber().equals(mobileNumber)) {
            return patient;
        }
    }

    return null;
   }

   private static void bookAppointment(Scanner scanner) {

        System.out.println("\n===== BOOK APPOINTMENT =====");

        // Step 1: Read Patient Mobile Number
        String mobileNumber = ScannerHelper.readMobileNumber(scanner, "Enter Mobile Number: ");

        // Step 2: Check whether patient is registered
        Patient patient = findPatientByMobile(mobileNumber);

        if (patient == null) {
            System.out.println("Patient is not registered.");
            System.out.println("Please register the patient first.");
            return;
        }
        Specialization specialization = ScannerHelper.readEnumchoice(scanner, "",Specialization.values());

        // Step 3: Select Appointment Slot
        String slot = ScannerHelper.readAppointmentSlot(scanner);

        // Step 4: Get Doctors List
        ArrayList<Doctor> doctorList = AdminMenu.getDoctors();

        if (doctorList.isEmpty()) {
            System.out.println("No doctors are available.");
            return;
        }

        // Step 5: Find doctors available in this slot
        ArrayList<Doctor> availableDoctors = new ArrayList<>();

        for (Doctor doctor : doctorList) {

            if (doctor.getSpecialization() == specialization
                    && doctor.isSlotAvailable(slot)) {

                availableDoctors.add(doctor);

            }

        }

        // Step 6: Check availability
        if (availableDoctors.isEmpty()) {
            System.out.println("Sorry! No doctor is available for this slot.");
            return;
        }

        // Step 7: Randomly assign a doctor
        Random random = new Random();

        Doctor assignedDoctor =
                availableDoctors.get(random.nextInt(availableDoctors.size()));

        // Step 8: Block the slot
        assignedDoctor.bookSlot(slot);

        // Step 9: Create Appointment
        Appointment appointment =
                new Appointment(patient, assignedDoctor, slot);

        appointmentList.add(appointment);

        // Step 10: Confirmation
        System.out.println("\n===== APPOINTMENT BOOKED SUCCESSFULLY =====");
        System.out.println(appointment);
    }

}
