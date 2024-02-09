import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Database implements DataBaseFunctions {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";
    private Connection connection = null;
    private Statement statement = null;


    private final String createUserData = "CREATE TABLE usersData (id SERIAL PRIMARY KEY,PatientName VARCHAR(255),age INT,gender VARCHAR(10),problem VARCHAR(30))";

    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Creating User DataTable
    public void createUserDataTable() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(createUserData);
            System.out.println("Users table has been created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public StringBuilder getSolution(String problemSolution) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("select Solution.solution from solution where problematic = ?");
            StringBuilder resultString = new StringBuilder();
            statement1.setString(1, problemSolution);
            ResultSet solution = statement1.executeQuery();
            while (solution.next()) {
                String solution1 = solution.getString("solution");
                resultString.append(solution1).append("\n");
            }
            connection.close();
            statement1.close();
            return resultString;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createCustomersTable() throws SQLException {

    }


    public void addPatient(String PatientName, int age, String gender, String problem) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("INSERT INTO usersData (patientname,age,gender,problem) VALUES (?,?,?,?)");
            statement1.setString(1, PatientName);
            statement1.setInt(2, age);
            statement1.setString(3, gender);
            statement1.setString(4, problem);
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void getPatient(int id) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM usersData WHERE id = ?");
            statement1.setInt(1, id);
            ResultSet result = statement1.executeQuery();
            while (result.next()) {
                int userId = result.getInt("id");
                String PatientName = result.getString("PatientName");
                int age = result.getInt("age");
                String gender = result.getString("gender");
                String problem = result.getString("problem");
                System.out.println("ID: " + userId);
                System.out.println("Patient Name: " + PatientName);
                System.out.println("AGE: " + age);
                System.out.println("GENDER: " + gender);
                System.out.println("Problem: " + problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update User
    public void updateUser(int id, String PatientName, int age, String gender, String problem) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usersData SET PatientName = ?,age = ?,gender = ?,problem = ? WHERE id = ?");
            statement.setString(1, PatientName);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, problem);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete user
    public void deleteUser(String name) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("DELETE FROM usersData WHERE patientname = ?");
            statement1.setString(1, name);
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSolutionByProblem(String problematic) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("SELECT solution.solution FROM solution WHERE problematic = ?");
            statement1.setString(1, problematic);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()) {
                String problemSolution = resultSet.getString("solution");
                System.out.println("Instruction for solving your problem : \n  " + problemSolution);
            }
            return statement1.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problematic;
    }

    public boolean checkUserExists(String patientname) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usersData WHERE patientname = ? ");
            stmt.setString(1, patientname);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkSolution(String problematic) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM solution WHERE problematic = ? ");
            stmt.setString(1, problematic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getAllPatients() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usersData");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int userId = result.getInt("id");
                String patientname = result.getString("patientname");
                int age = result.getInt("age");
                String gender = result.getString("gender");


                System.out.println("ID: " + userId + ", Patient name: " + patientname + ",age: " + age + "gender: " + gender);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }
    public void getAllProblematic () {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT problematic FROM solution");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String problematic = result.getString("problematic");
                System.out.println(problematic);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    }






