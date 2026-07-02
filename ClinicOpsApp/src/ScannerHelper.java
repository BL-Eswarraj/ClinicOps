import java.util.Scanner;

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
}
