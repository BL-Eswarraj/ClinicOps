public class Doctor {
    
    //Declaring variables
    private String id;
    private String name;
    private Specialization specialization;
    private int experience;
    private Shift shift;

        // Constructor
    public Doctor(String id, String name, Specialization specialization,
                  int experience, Shift shift) {

        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.shift = shift;
    }

        // toString() Method
    @Override
    public String toString() {

        return "Doctor ID      : " + id +
               "\nName           : " + name +
               "\nSpecialization : " + specialization +
               "\nExperience     : " + experience + " Years" +
               "\nShift          : " + shift +
               "\n------------------------------------";
    }

}
