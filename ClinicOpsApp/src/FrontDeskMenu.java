import java.util.Scanner;

public class FrontDeskMenu {
    private static final int PATIENT_REGISTRATION = 1;
    private static final int BOOK_APPOINTMENT =2;
    private static final int LOGOUT = 3;

    public static void showMenu(Scanner scanner){

        boolean logout = false;

        while(!logout){
            System.out.println("----FRONT DESK MENU----");
            System.out.println();
            System.out.println("1. Patient Registration");
            System.out.println("2. Book Appointment");
            System.out.println("3. Logout");
            System.out.print("Enter Your Choice: ");

            int choice = ScannerHelper.readInt(scanner);
            switch(choice){
                case PATIENT_REGISTRATION:
                    System.out.println("Initiating Patient Registration Process...");
                    break;

                case BOOK_APPOINTMENT:
                    System.out.println("Initiating Book Appointment Process...");
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

}
