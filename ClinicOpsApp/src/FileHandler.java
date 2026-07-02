import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<Doctor> readDoctorsFromCSV(String filePath, int startId) {

        ArrayList<Doctor> doctors = new ArrayList<>();

        int idCounter = startId;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split CSV row
                String[] data = line.split(",");

                // Validate number of columns
                if (data.length != 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                try {

                    String name = data[0].trim();

                    Specialization specialization =
                            Specialization.valueOf(data[1].trim().toUpperCase());

                    int experience =
                            Integer.parseInt(data[2].trim());

                    Shift shift =
                            Shift.valueOf(data[3].trim().toUpperCase());

                    String id = String.format("D%04d", idCounter++);

                    Doctor doctor = new Doctor(
                            id,
                            name,
                            specialization,
                            experience,
                            shift);

                    doctors.add(doctor);

                } catch (IllegalArgumentException e) {

                    System.out.println("Invalid Specialization/Shift/Experience: " + line);

                }

            }

        } catch (IOException e) {

            System.out.println("Unable to read file: " + e.getMessage());

        }

        return doctors;
    }
}