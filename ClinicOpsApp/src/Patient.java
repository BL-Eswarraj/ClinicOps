public class Patient {

    // Instance Variables
    private String id;
    private String name;
    private String gender;
    private int age;
    private String mobileNumber;

    // Constructor
    public Patient(String id,
                   String name,
                   String gender,
                   int age,
                   String mobileNumber) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {

        return "Patient ID    : " + id +
               "\nName           : " + name +
               "\nGender         : " + gender +
               "\nAge            : " + age +
               "\nMobile Number  : " + mobileNumber +
               "\n------------------------------------";
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}