    import java.util.Scanner;


    public class ClinicApp {

        private static final int ROLE_ADMIN = 1;
        private static final int ROLE_FRONTDESK =2;
        private static final int EXIT =3;

        // Above declaration is for if the value is modified only one time
        public static void main(String[] args){
            
            Scanner scanner = new Scanner(System.in); //Reads Keyboard Input
            boolean exitApp = false;

            while (!exitApp)
            {
            System.out.println("*** Welome to Clinic App ***");
            System.out.println();      
            System.out.println("---*** Main Menu ***---");
            System.out.println();
            System.out.println("1. Clinic Admin");
            System.out.println("2. Front Desk Executive");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
        
            int choice = ScannerHelper.readInt(scanner);
            switch (choice)
            {
                case ROLE_ADMIN:
                    AdminMenu.showMenu(scanner);
                    break;
                case ROLE_FRONTDESK:
                    FrontDeskMenu.showMenu(scanner);
                    break;
                case EXIT:
                    System.out.println("Thank you for Using Clinic App....");
                    System.out.println("Good Bye...");
                    exitApp = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            
        }
        scanner.close();
        }
    }
