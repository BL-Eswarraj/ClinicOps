public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String slot;

    public Appointment(Patient patient,
                       Doctor doctor,
                       String slot) {

        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
    }

    @Override
    public String toString() {

        return "===== Appointment =====" +
               "\nPatient : " + patient +
               "\nDoctor  : " + doctor +
               "\nSlot    : " + slot;
    }
}
