import java.util.Scanner;

public class AdminMenu {

    private static final int DOC_ENTRY = 1;
    private static final int BULK_DATA_ENTRY = 2;
    private static final int VIEW_AUDIT_LOGS = 3;
    private static final int LOGOUT = 4;

    public static void showMenu(Scanner scanner){
        boolean logout = false;
        while(!logout)
        {
        System.out.println("------ ADMIN MENU ------");
        System.out.println();
        System.out.println("1. Doctor Data Entry");
        System.out.println("2. Bulk Data Entry");
        System.out.println("3. View Audit Logs");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");

        int choice = ScannerHelper.readInt(scanner);
        switch(choice)
        {
            case DOC_ENTRY:
                System.out.println("Doctor data Entry....");
                break;
            case BULK_DATA_ENTRY:
                System.out.println("Bulk Data Entry.....");
                break;
            case VIEW_AUDIT_LOGS:
                System.out.println("View Logs....");
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
}
