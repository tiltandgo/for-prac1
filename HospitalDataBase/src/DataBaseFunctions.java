import java.sql.SQLException;

public interface DataBaseFunctions {
    void createUserDataTable() throws SQLException;

    void createCustomersTable() throws SQLException;
    //////////////////////////////////////////////////////////////////////////////////////

    void getPatient(int id);

    void updateUser(int id, String PatientName, int age, String gender, String problem);

    void deleteUser(String name);


}
