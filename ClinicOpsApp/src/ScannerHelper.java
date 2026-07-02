import java.util.Scanner;
import java.util.regex.Pattern;


public class ScannerHelper {

    public static int readInt(Scanner scanner){
        

        while (true){
            if (scanner.hasNextInt()){
                return  scanner.nextInt();
            }
            else{
                System.out.print("Invalid Input Please Enter a number:  ");
                scanner.next();
            }
        }
   }
   // Read string Input
   public static String readString(Scanner scanner, String prompt) {

    while (true) {

        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (!input.isEmpty()) {
            return input;
        } else {
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
public static int readIntwithPrompt(Scanner scanner, String prompt) {

    while (true) {

        System.out.print(prompt);

        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            scanner.nextLine();   // consume the newline
            return value;
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
}
public static <T extends Enum<T>>T readEnumchoice(Scanner scanner, String prompt,  T[] values){

    while (true){
        for (int i = 0; i < values.length; i++){
            System.out.println((i+1)+"."+ values[i]);

        }
        int choice = readIntwithPrompt(scanner, "Select choice Number: ");

        if (choice > 0 && choice <= values.length){
            return values[choice - 1];
        } 

        System.out.println(">>Error:  Invalid Selection Try Again");
    }

 }
 public static String readMobileNumber(Scanner scanner, String prompt) {

    // Indian mobile number regex
    String regex = "^[6-9]\\d{9}$";

    while (true) {

        System.out.print(prompt);

        String mobile = scanner.nextLine().trim();

        if (Pattern.matches(regex, mobile)) {
            return mobile;
        }

        System.out.println("Invalid Mobile Number. Please try again.");
    }
 }
   private static final String[] APPOINTMENT_SLOTS = {
        "09:00 AM",
        "09:30 AM",
        "10:00 AM",
        "10:30 AM",
        "11:00 AM",
        "11:30 AM",
        "12:00 PM",
        "12:30 PM",

        "04:00 PM",
        "04:30 PM",
        "05:00 PM",
        "05:30 PM",
        "06:00 PM",
        "06:30 PM",
        "07:00 PM",
        "07:30 PM"
    };

    public static String readAppointmentSlot(Scanner scanner) {

        while (true) {

            System.out.println("\nAvailable Appointment Slots");

            for (int i = 0; i < APPOINTMENT_SLOTS.length; i++) {
                System.out.println((i + 1) + ". " + APPOINTMENT_SLOTS[i]);
            }

            int choice = readIntwithPrompt(scanner,
                    "Select Slot Number: ");

            if (choice >= 1 && choice <= APPOINTMENT_SLOTS.length) {
                return APPOINTMENT_SLOTS[choice - 1];
            }

            System.out.println("Invalid Slot Selection.");
        }
    }
 
}
