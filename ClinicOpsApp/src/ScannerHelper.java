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
}
