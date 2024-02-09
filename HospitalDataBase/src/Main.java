import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        System.out.println("Type 1,if you want to join in our hospital");
        System.out.println("Type 2,if you want to remove from our hospital");
        System.out.println("Type 3,if you first time and want to know how to solve your problem");;
        System.out.println("Type 4,if you an employee of our hospital");
        Scanner main = new Scanner(System.in);
        int main_1 = main.nextInt();

        switch (main_1) {
            case 1:
                System.out.println("Please,type your name,age,gender,problem");

                Scanner PatientName = new Scanner(System.in);
                Scanner age = new Scanner(System.in);
                Scanner gender = new Scanner(System.in);
                Scanner problem = new Scanner(System.in);

                String PatientName1 = PatientName.nextLine();
                int age1 = age.nextInt();
                String gender1 = gender.nextLine();
                String problem1 = problem.nextLine();
                if (age1 < 100 && age1 > 0) {
                    database.addPatient(PatientName1, age1, gender1, problem1);
                    System.out.println("You have been registered.");
                } else {
                    System.out.println("You cannot be in this age");
                }
                break;
            case 2:
                System.out.println("If you want to leave press your name");
                Scanner PatientName2 = new Scanner(System.in);
                String PatientName3 = PatientName2.nextLine();
                if (database.checkUserExists(PatientName3)) {
                    database.deleteUser(PatientName3);
                    System.out.println("Patient deleted.");
                } else {
                    System.out.println("User is not exist.");
                }
                break;
            case 3:
                System.out.println("Press your problem from list");
                database.getAllProblematic();
                Scanner problem2 = new Scanner(System.in);
                String problemtoSolve = problem2.nextLine();
                if (database.checkSolution(problemtoSolve)) {
                    System.out.println(database.getSolution(problemtoSolve).toString());
                } else {
                    System.out.println("We dont know,how to heal this.");
                }
                break;
            case 4:
                Scanner password = new Scanner(System.in);
                int password1 = password.nextInt();

                if (password1 == 1234) {
                    System.out.println("You are in employee panel.");
                    System.out.println("Type 1,to create a user data table");
                    System.out.println("Type 2,to delete patient");
                    System.out.println("Type 3,to update patient");
                    System.out.println("Type 4,to see all patients");
                    System.out.println("Type 5,to get a patient by id");
                    Scanner decision = new Scanner(System.in);
                    int decision1 = decision.nextInt();
                    if (decision1 == 1) {
                        try {
                            database.createUserDataTable();
                            System.out.println("Table created.");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else if (decision1 == 2) {
                        Scanner PatientNam = new Scanner(System.in);
                        String PatientNam2 = PatientNam.nextLine();
                        if (database.checkUserExists(PatientNam2)) {
                            database.deleteUser(PatientNam2);
                            System.out.println("Patient deleted.");
                        } else {
                            System.out.println("User is not exist.");
                        }
                    } else if (decision1 == 3) {
                        System.out.println("Press information id,patient name,age,gender,problem");
                        Scanner id = new Scanner(System.in);
                        Scanner PatientName_1 = new Scanner(System.in);
                        Scanner age_1 = new Scanner(System.in);
                        Scanner gender_1 = new Scanner(System.in);
                        Scanner problem_1 = new Scanner(System.in);
                        int id1 = id.nextInt();
                        String PatientName_2 = PatientName_1.nextLine();
                        int age_2 = age_1.nextInt();
                        String gender_2 = gender_1.nextLine();
                        String problem_2 = problem_1.nextLine();
                        database.updateUser(id1, PatientName_2, age_2, gender_2, problem_2);
                    } else if (decision1 == 4) {
                        database.getAllPatients();
                    } else {
                        System.out.println("WRONG.");
                    }
                    break;


                }

        }

    }
}










