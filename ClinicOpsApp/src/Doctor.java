import java.util.ArrayList;

public class Doctor {
    
    //Declaring variables
    private String id;
    private String name;
    private Specialization specialization;
    private int experience;
    private Shift shift;

    public Specialization getSpecialization() {
        return specialization;
    }

    private ArrayList<String> bookedSlots;


    public boolean isShiftCompatible(String slot) {

        // Morning slots
        if (slot.startsWith("09") ||
            slot.startsWith("10") ||
            slot.startsWith("11") ||
            slot.startsWith("12")) {

            return shift == Shift.MORNING || shift == Shift.BOTH;
        }

        // Evening slots
        return shift == Shift.EVENING || shift == Shift.BOTH;
    }

    // Constructor
    public Doctor(String id, String name, Specialization specialization,
                  int experience, Shift shift) {

        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.shift = shift;

        bookedSlots = new ArrayList<>();
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
    public boolean isSlotAvailable(String slot) {

        return !bookedSlots.contains(slot);

    }
    public void bookSlot(String slot) {

        bookedSlots.add(slot);

        AuditLogger.log("Slot Added: "+ slot, "INFO");

    }

    public String getName() {
        return name;
    }

    public Shift getShift() {
        return shift;
    }

    public String getId() {
        return id;
    }

}
