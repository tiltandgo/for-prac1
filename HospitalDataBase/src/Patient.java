public class Patient {
    private int id;
    private String PatientName;
    private int age;
    private String gender;
    private String problem;

    public Patient(String PatientName,int age,String gender,String problem){
       this.PatientName = PatientName;
       this.age = age;
       this.gender = gender;
       this.problem = problem;
    }

    public int getId() {
        return id;
    }


    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}

