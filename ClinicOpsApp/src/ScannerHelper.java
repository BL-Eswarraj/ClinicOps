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
}
